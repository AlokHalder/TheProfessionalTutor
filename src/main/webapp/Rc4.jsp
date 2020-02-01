<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.util.HashMap"%>
<%
    class ResponseData {

        private HashMap info = new HashMap(); // Stores the data for
        // the phone directory.

        void addEntry(String name, String number) {
            // Record the phone number for a specified name.
            info.put(name, number);
        }

        String getData(String name) {
            // Retrieve the phone number for a specified name.
            // Returns null if there is no number for the name.
            return (String) info.get(name);
        }
    } // end class PhoneDirectory


    /**
     * This class contains two static methods for Base64 encoding and decoding.
     *
     * @author <a href="http://izhuk.com">Igor Zhukovsky</a>
     */
    class Base64 {

        /**
         *  Decodes BASE64 encoded string.
         *  @param encoded string
         *  @return decoded data as byte array
         */
        byte[] decode(String encoded) {
            int i;
            byte output[] = new byte[3];
            int state;

            ByteArrayOutputStream data = new ByteArrayOutputStream(encoded.length());

            state = 1;
            for (i = 0; i < encoded.length(); i++) {
                byte c;
                {
                    char alpha = encoded.charAt(i);
                    if (Character.isWhitespace(alpha)) {
                        continue;
                    }

                    if ((alpha >= 'A') && (alpha <= 'Z')) {
                        c = (byte) (alpha - 'A');
                    } else if ((alpha >= 'a') && (alpha <= 'z')) {
                        c = (byte) (26 + (alpha - 'a'));
                    } else if ((alpha >= '0') && (alpha <= '9')) {
                        c = (byte) (52 + (alpha - '0'));
                    } else if (alpha == '+') {
                        c = 62;
                    } else if (alpha == '/') {
                        c = 63;
                    } else if (alpha == '=') {
                        break; // end
                    } else {
                        return null; // error
                    }
                }

                switch (state) {
                    case 1:
                        output[0] = (byte) (c << 2);
                        break;
                    case 2:
                        output[0] |= (byte) (c >>> 4);
                        output[1] = (byte) ((c & 0x0F) << 4);
                        break;
                    case 3:
                        output[1] |= (byte) (c >>> 2);
                        output[2] = (byte) ((c & 0x03) << 6);
                        break;
                    case 4:
                        output[2] |= c;
                        data.write(output, 0, output.length);
                        break;
                }
                state = (state < 4 ? state + 1 : 1);
            } // for

            if (i < encoded.length()) /* then '=' found, but the end of string */ {
                switch (state) {
                    case 3:
                        data.write(output, 0, 1);
                        return (encoded.charAt(i) == '=') && (encoded.charAt(i + 1) == '=')
                                ? data.toByteArray() : null;
                    case 4:
                        data.write(output, 0, 2);
                        return (encoded.charAt(i) == '=') ? data.toByteArray() : null;
                    default:
                        return null;
                }
            } else {
                return (state == 1 ? data.toByteArray() : null); /* end of string */
            }

        } // decode
        final static String base64 =
                "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

        /**
         *  Encodes binary data by BASE64 method.
         *  @param data binary data as byte array
         *  @return encoded data as String
         */
        String encode(byte[] data) {

            char output[] = new char[4];
            int state = 1;
            int restbits = 0;
            int chunks = 0;

            StringBuffer encoded = new StringBuffer();

            for (int i = 0; i < data.length; i++) {
                int ic = (data[i] >= 0 ? data[i] : (data[i] & 0x7F) + 128);
                switch (state) {
                    case 1:
                        output[0] = base64.charAt(ic >>> 2);
                        restbits = ic & 0x03;
                        break;
                    case 2:
                        output[1] = base64.charAt((restbits << 4) | (ic >>> 4));
                        restbits = ic & 0x0F;
                        break;
                    case 3:
                        output[2] = base64.charAt((restbits << 2) | (ic >>> 6));
                        output[3] = base64.charAt(ic & 0x3F);
                        encoded.append(output);

                        // keep no more the 76 character per line
                        chunks++;
                        if ((chunks % 19) == 0) {
                            encoded.append("\r\n");
                        }
                        break;
                }
                state = (state < 3 ? state + 1 : 1);
            } // for

            /* final */
            switch (state) {
                case 2:
                    output[1] = base64.charAt((restbits << 4));
                    output[2] = output[3] = '=';
                    encoded.append(output);
                    break;
                case 3:
                    output[2] = base64.charAt((restbits << 2));
                    output[3] = '=';
                    encoded.append(output);
                    break;
            }

            return encoded.toString();
        } // encode()
    } // Base64

    /**
    Author		  : R. Prince - Java coded based on the original VB source by Mike Shaffer
    Date		  : 01/2004
    Name	 	  : RC4CipherEntity
    Stereotype	  : Entity
    Description	  : When called from a JSP/Servlet the RC4CipherEntity deciphers or enciphers a string of data.
     **/
    class RC4 {

        private byte state[] = new byte[256];
        private int x;
        private int y;

        /**
         * Initializes the class with a string key. The length
         * of a normal key should be between 1 and 2048 bits.  But
         * this method doens't check the length at all.
         *
         * @param key   the encryption/decryption key
         */
        RC4(String key) throws NullPointerException {
            this(key.getBytes());
        }

        /**
         * Initializes the class with a byte array key.  The length
         * of a normal key should be between 1 and 2048 bits.  But
         * this method doens't check the length at all.
         *
         * @param key   the encryption/decryption key
         */
        RC4(byte[] key) throws NullPointerException {

            for (int i = 0; i < 256; i++) {
                state[i] = (byte) i;
            }

            x = 0;
            y = 0;

            int index1 = 0;
            int index2 = 0;

            byte tmp;

            if (key == null || key.length == 0) {
                throw new NullPointerException();
            }

            for (int i = 0; i < 256; i++) {

                index2 = ((key[index1] & 0xff) + (state[i] & 0xff) + index2) & 0xff;

                tmp = state[i];
                state[i] = state[index2];
                state[index2] = tmp;

                index1 = (index1 + 1) % key.length;
            }



        }

        /** 
         * RC4 encryption/decryption.
         *
         * @param data  the data to be encrypted/decrypted
         * @return the result of the encryption/decryption
         */
        byte[] rc4(String data) {

            if (data == null) {
                return null;
            }

            byte[] tmp = data.getBytes();

            this.rc4(tmp);

            return tmp;
        }

        /** 
         * RC4 encryption/decryption.
         *
         * @param buf  the data to be encrypted/decrypted
         * @return the result of the encryption/decryption
         */
        byte[] rc4(byte[] buf) {

            //int lx = this.x;
            //int ly = this.y;

            int xorIndex;
            byte tmp;

            if (buf == null) {
                return null;
            }

            byte[] result = new byte[buf.length];

            for (int i = 0; i < buf.length; i++) {

                x = (x + 1) & 0xff;
                y = ((state[x] & 0xff) + y) & 0xff;

                tmp = state[x];
                state[x] = state[y];
                state[y] = tmp;

                xorIndex = ((state[x] & 0xff) + (state[y] & 0xff)) & 0xff;
                result[i] = (byte) (buf[i] ^ state[xorIndex]);
            }

            //this.x = lx;
            //this.y = ly;

            return result;
        }
    }
%>