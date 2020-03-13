package com.pcs.ptutors.model;
/*
public class AllSearchResultAction {

}*/


import com.pcs.ptutors.tutorialcenter.vo.TutorialCenterDataVO;
import com.pcs.ptutors.model.SearchTutorService;
import com.pcs.ptutors.model.TutorialCenterModel;
import com.pcs.ptutors.model.PSearchManager;
import com.pcs.ptutors.model.SearchVO;
import com.pcs.ptutors.vo.StudentRegistrationVO;
import com.pcs.ptutors.vo.TutorRegistrationVO;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
	
public class AllSearchResultAction extends Action {

    private static String SUCCESS = null;

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
        DynaActionForm dynaActionForm = (DynaActionForm) form;
        HttpSession session = request.getSession();
        int searchOption = Integer.parseInt(dynaActionForm.getString("searchoptions"));
        SearchVO searchVO = new SearchVO();
        BeanUtils.copyProperties(searchVO, dynaActionForm);
        SearchTutorService searchTutorService = new SearchTutorService();
        String queryForSearch = null;
        switch (searchOption) {
            case 1:
 //              queryForSearch = PSearchManager.generateQuery(searchVO);
//                System.out.println("aaa "+queryForSearch);
 //              List<TutorRegistrationVO> templistOfTutorSearchResult =PSearchManager.getSearchedTutorsDetails(queryForSearch).getListOfSearchedTutors();
//               
//                List searchedTutorsList = PSearchManager.getneratePagination(templistOfTutorSearchResult,1);
//                dynaActionForm.set("listOfTutorSearchResultList", searchedTutorsList);
//                int totalTutorCount = templistOfTutorSearchResult.size();
//                int totalPageForTutors = 0;
//                if (totalTutorCount % 10 == 0) {
//                    totalPageForTutors = totalTutorCount / 10;
//                } else {
//                    totalPageForTutors = totalTutorCount / 10 + 1;
//                }
//                String locationForTutors = searchVO.getTutorCityLocation();
//                String subjectForTutors = searchVO.getMainsubject();
//                String segLevelForTutors = searchVO.getTeachingLevel();
//
//                request.setAttribute("locationForTutors", locationForTutors);
//                request.setAttribute("subjectForTutors", subjectForTutors);
//                request.setAttribute("segLevelForTutors", segLevelForTutors);
//                request.setAttribute("totalPageForTutors", totalPageForTutors);
//                request.setAttribute("totalTutorCount", totalTutorCount);
                //dynaActionForm.set("listOfTutorSearchResultList", searchTutorService.getAllTutorsByTeachingPatternLocationSublectSegmentLevelPageId(searchVO).getListOfSearchedTutors());
       List<TutorRegistrationVO> tutorRegistrationVOList = searchTutorService.getAllTutorsByTeachingPatternLocationSublectSegmentLevelPageId(searchVO).getListOfSearchedTutors();
                for (int k = 0; k < tutorRegistrationVOList.size(); k++) {
                    String folderPath = request.getRealPath("/") + "Photo-Upload";

                    File folder = new File(folderPath);
                    File[] listFiles = folder.listFiles();

                    if (listFiles != null) {
                        for (int i = 0; i < listFiles.length; i++) {
                            String fileName = listFiles[i].getName();
                            System.out.println("file name===" + fileName);
                            if (fileName.startsWith(tutorRegistrationVOList.get(k).getTutorId())) {
                                tutorRegistrationVOList.get(k).setPhotoFileName(fileName);
                                System.out.println("ggggggggggggghgshgchghg===" + tutorRegistrationVOList.get(i).getPhotoFileName());
                                break;
                            }
                        }
                    }
        }
                
                dynaActionForm.set("listOfTutorSearchResultList", tutorRegistrationVOList);
              // tutorRegistrationVOList = searchTutorService.getAllTutorsByTeachingPatternLocationSublectSegmentLevelPageId(searchVO).getListOfSearchedTutors();
                request.setAttribute("pageNo", 1);
               // int totalTutorCountSearch = searchTutorService.getAllTutorCountSearch(searchVO);
                int totalTutorCountSearch=tutorRegistrationVOList.size();
                dynaActionForm.set("searchResultCount", totalTutorCountSearch);

                List searchedTutorAlList = PSearchManager.getneratePagination(tutorRegistrationVOList, 1);
                System.out.println("searchedTutorAlList in action,...."+searchedTutorAlList);
                dynaActionForm.set("listOfTutorSearchResultList", searchedTutorAlList);
                
                int totalPageForTutors = 0;
                if (totalTutorCountSearch % 10 == 0) {
                    totalPageForTutors = totalTutorCountSearch / 10;
                } else {
                    totalPageForTutors = totalTutorCountSearch / 10 + 1;
                }
                String locationForTutor = searchVO.getTutorCityLocation();
                String subjectForTutor = searchVO.getMainsubject();
                String segLevelForTutor = searchVO.getTeachingLevel();

                request.setAttribute("locationForTutor", locationForTutor);
                request.setAttribute("subjectForTutor", subjectForTutor);
                request.setAttribute("segLevelForTutor", segLevelForTutor);
                request.setAttribute("totalPageForTutors", totalPageForTutors);
                request.setAttribute("totalTutorCountSearch", totalTutorCountSearch);
                System.out.println("totalTutorCountSearch in action......" + totalTutorCountSearch);
                request.setAttribute("searchOption", searchOption);
                System.out.println("searchOption in action......." + searchOption);
               

                SUCCESS = "searchHomeTutors";
                break;
            case 2:
                queryForSearch = PSearchManager.generateQuery(searchVO);
                List<StudentRegistrationVO> tempListOfSearch = PSearchManager.getSearchedStudentsDetails(queryForSearch).getListOfSearchedStudent();
                
                for (int k = 0; k < tempListOfSearch.size(); k++) {
                    String folderPath = request.getRealPath("/") + "Photo-Upload";

                    File folder = new File(folderPath);
                    File[] listFiles = folder.listFiles();

                    if (listFiles != null) {
                        for (int i = 0; i < listFiles.length; i++) {
                            String fileName = listFiles[i].getName();
                            System.out.println("file name===" + fileName);
                            if (fileName.startsWith(tempListOfSearch.get(k).getStudentId())) {
                                tempListOfSearch.get(k).setPhotoFileName(fileName);
                                System.out.println("ggggggggggggghgshgchghg===" + tempListOfSearch.get(i).getPhotoFileName());
                                break;
                            }
                        }
                    }
        }
                
                 
                dynaActionForm.set("searchedStudentsList", tempListOfSearch); 
                List searchedStudentsList = PSearchManager.getneratePagination(tempListOfSearch, 1);
                dynaActionForm.set("searchedStudentsList", searchedStudentsList);
                int totalStudentCount = tempListOfSearch.size();
                dynaActionForm.set("searchResultCount", totalStudentCount);
                int totalPageForStudent = 0;
                if (totalStudentCount % 10 == 0) {
                    totalPageForStudent = totalStudentCount / 10;
                } else {
                    totalPageForStudent = totalStudentCount / 10 + 1;
                }
                String locationForStudent = searchVO.getTutorCityLocation();
                String subjectForStudent = searchVO.getMainsubject();
                String segLevelForStudent = searchVO.getTeachingLevel();

                request.setAttribute("locationForStudent", locationForStudent);
                request.setAttribute("subjectForStudent", subjectForStudent);
                request.setAttribute("segLevelForStudent", segLevelForStudent);
                request.setAttribute("totalPageForStudent", totalPageForStudent);
                request.setAttribute("searchResultCount", totalStudentCount);
                SUCCESS = "searchStudents";
                break;
            case 3:
                //dynaActionForm.set("listOfTutorSearchResultList", searchTutorService.getAllTutorsByTeachingPatternLocationSublectSegmentLevelPageId(searchVO).getListOfSearchedTutors());
                List<TutorRegistrationVO> tutorRegistrationVOList1 = searchTutorService.getAllTutorsByTeachingPatternLocationSublectSegmentLevelPageId(searchVO).getListOfSearchedTutors();
                for (int k = 0; k < tutorRegistrationVOList1.size(); k++) {
                    String folderPath = request.getRealPath("/") + "Photo-Upload";

                    File folder = new File(folderPath);
                    File[] listFiles = folder.listFiles();

                    if (listFiles != null) {
                        for (int i = 0; i < listFiles.length; i++) {
                            String fileName = listFiles[i].getName();
                            System.out.println("file name===" + fileName);
                            if (fileName.startsWith(tutorRegistrationVOList1.get(k).getTutorId())) {
                                tutorRegistrationVOList1.get(k).setPhotoFileName(fileName);
                                System.out.println("ggggggggggggghgshgchghg===" + tutorRegistrationVOList1.get(i).getPhotoFileName());
                                break;
                            }
                        }
                    }
        }
                dynaActionForm.set("listOfTutorSearchResultList", tutorRegistrationVOList1);
                //totalTutorCountSearch = searchTutorService.getAllTutorCountSearch(searchVO);
                totalTutorCountSearch=tutorRegistrationVOList1.size();
                dynaActionForm.set("searchResultCount", totalTutorCountSearch);
                
                List searchedTutorAlList1 = PSearchManager.getneratePagination(tutorRegistrationVOList1, 1);
                dynaActionForm.set("listOfTutorSearchResultList", searchedTutorAlList1);
                totalPageForTutors = 0;
                if (totalTutorCountSearch % 10 == 0) {
                    totalPageForTutors = totalTutorCountSearch / 10;
                } else {
                    totalPageForTutors = totalTutorCountSearch / 10 + 1;
                }
                locationForTutor = searchVO.getTutorCityLocation();
                subjectForTutor = searchVO.getMainsubject();
                segLevelForTutor = searchVO.getTeachingLevel();
                request.setAttribute("locationForTutor", locationForTutor);
                request.setAttribute("subjectForTutor", subjectForTutor);
                request.setAttribute("segLevelForTutor", segLevelForTutor);
                request.setAttribute("totalPageForTutors", totalPageForTutors);
                request.setAttribute("totalTutorCountSearch", totalTutorCountSearch);
                request.setAttribute("searchOption", searchOption);
                session.setAttribute("locationForTutor", locationForTutor);
                session.setAttribute("subjectForTutor", subjectForTutor);
                session.setAttribute("segLevelForTutor", segLevelForTutor);
                session.setAttribute("totalPageForTutors", totalPageForTutors);
                session.setAttribute("searchOption", searchOption);

                SUCCESS = "searchTutoringJobs";
                break;
            case 4:
               

//                  TutorialCenterModel centerModel = new TutorialCenterModel();
//                dynaActionForm.set("searchedTutorialCenterList", centerModel.searchTutorialCenters(searchVO.getTutorCityLocation(), searchVO.getMainsubject()));
//                int totalCount = centerModel.searchTotalTutorialCenters(searchVO.getTutorCityLocation(), searchVO.getMainsubject());
//                dynaActionForm.set("searchResultCount", totalCount);
                queryForSearch = PSearchManager.generateQuery(searchVO);
                System.out.println("case 4 ==="+queryForSearch);
                List<TutorialCenterDataVO> templistOfTutorialSearchResult =PSearchManager.getSearchedTutorialDetails(queryForSearch).getListofsearchedTutorial();
                List searchedTutorialList = PSearchManager.getneratePagination(templistOfTutorialSearchResult, 1);
                dynaActionForm.set("searchedTutorialCenterList", searchedTutorialList);
                int totalTutorialCount = templistOfTutorialSearchResult.size();
                dynaActionForm.set("searchResultCount", totalTutorialCount);
                int totalPageForTutorial = 0;
                if (totalTutorialCount % 10 == 0) {
                    totalPageForTutorial = totalTutorialCount / 10;
                } else {
                    totalPageForTutorial = totalTutorialCount / 10 + 1;
                }

                String locationForCentre = searchVO.getTutorCityLocation();

                request.setAttribute("locationForCentre", locationForCentre);
               
                request.setAttribute("totalPageForTutorial", totalPageForTutorial);
                request.setAttribute("searchResultCount", totalTutorialCount);
                SUCCESS = "searchTutorialCenters";
                break;
            case 5:

                // Integer teachingPatternId = Integer.parseInt(searchVO.getSearchoptions());//For Faculty Jobs
                // dynaActionForm.set("listOfTutorSearchResult", searchTutorService.getAllTutorsByTeachingPatternLocationSublectSegmentLevelPageId(teachingPatternId, locationId, SubjectId, segmentLevelId, pageId));
                dynaActionForm.set("listOfTutorSearchResultList", searchTutorService.getAllTutorsByTeachingPatternLocationSublectSegmentLevelPageId(searchVO).getListOfSearchedTutors());
                List<TutorRegistrationVO> tutorRegistrationVOList2 = searchTutorService.getAllTutorsByTeachingPatternLocationSublectSegmentLevelPageId(searchVO).getListOfSearchedTutors();
                //totalTutorCountSearch = searchTutorService.getAllTutorCountSearch(searchVO);
                 for (int k = 0; k < tutorRegistrationVOList2.size(); k++) {
                    String folderPath = request.getRealPath("/") + "Photo-Upload";

                    File folder = new File(folderPath);
                    File[] listFiles = folder.listFiles();

                    if (listFiles != null) {
                        for (int i = 0; i < listFiles.length; i++) {
                            String fileName = listFiles[i].getName();
                            System.out.println("file name===" + fileName);
                            if (fileName.startsWith(tutorRegistrationVOList2.get(k).getTutorId())) {
                                tutorRegistrationVOList2.get(k).setPhotoFileName(fileName);
                                System.out.println("ggggggggggggghgshgchghg===" + tutorRegistrationVOList2.get(i).getPhotoFileName());
                                break;
                            }
                        }
                    }
        }
                dynaActionForm.set("listOfTutorSearchResultList", tutorRegistrationVOList2);
                totalTutorCountSearch=tutorRegistrationVOList2.size();
                dynaActionForm.set("searchResultCount", totalTutorCountSearch);
              
                List searchedTutorAlList2 = PSearchManager.getneratePagination(tutorRegistrationVOList2, 1);
                dynaActionForm.set("listOfTutorSearchResultList", searchedTutorAlList2);
                  totalPageForTutors = 0;
                if (totalTutorCountSearch % 10 == 0) {
                    totalPageForTutors = totalTutorCountSearch / 10;
                } else {
                    totalPageForTutors = totalTutorCountSearch / 10 + 1;
                }
                locationForTutor = searchVO.getTutorCityLocation();
                subjectForTutor = searchVO.getMainsubject();
                segLevelForTutor = searchVO.getTeachingLevel();
                request.setAttribute("locationForTutor", locationForTutor);
                request.setAttribute("subjectForTutor", subjectForTutor);
                request.setAttribute("segLevelForTutor", segLevelForTutor);
                request.setAttribute("totalPageForTutors", totalPageForTutors);
                request.setAttribute("totalTutorCountSearch", totalTutorCountSearch);
                request.setAttribute("searchOption", searchOption);
                SUCCESS = "searchOnlineTutors";
                break;
            case 6:
                TutorialCenterModel centerModel = new TutorialCenterModel();
                dynaActionForm.set("searchedTutorialCenterList", centerModel.searchTutorialCenters(searchVO.getTutorCityLocation(), searchVO.getMainsubject()));
                int totalCount = centerModel.searchTotalTutorialCenters(searchVO.getTutorCityLocation(), searchVO.getMainsubject());
                dynaActionForm.set("searchResultCount", totalCount);
                SUCCESS = "searchStudyMaterial";
                break;
            case 7:

                // Integer teachingPatternId = Integer.parseInt(searchVO.getSearchoptions());//For Faculty Jobs
                // dynaActionForm.set("listOfTutorSearchResult", searchTutorService.getAllTutorsByTeachingPatternLocationSublectSegmentLevelPageId(teachingPatternId, locationId, SubjectId, segmentLevelId, pageId));
                dynaActionForm.set("listOfTutorSearchResultList", searchTutorService.getAllTutorsByTeachingPatternLocationSublectSegmentLevelPageId(4, 0, 0, 0, 0));
                SUCCESS = "searchFacultyJobs";
                request.setAttribute("pageNo", 1);
                break;
        }
            return mapping.findForward(SUCCESS);
    }
}
