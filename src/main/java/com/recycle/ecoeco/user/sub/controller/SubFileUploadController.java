package com.recycle.ecoeco.user.sub.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
//@RequestMapping("/user/sub")
public class SubFileUploadController {

    @PostMapping("/single-file")
    public String singleFileUpload(@RequestParam String singleFileDescription,
                                   @RequestParam MultipartFile singleFile,
                                   Model model) {

        System.out.println("singleFileDescription : " + singleFileDescription);
        System.out.println("singleFile : " + singleFile);

        /* 서버로 전달된 File을 서버에서 설정하는 경로에 저장한다. */
        String root = "src/main/resources/static";
        String filePath = root + "/uploadFiles";
        File dir = new File(filePath);
        System.out.println(dir.getAbsolutePath());

        if(!dir.exists()) dir.mkdir();

        /* 파일명 변경 처리 */
        String originFileName = singleFile.getOriginalFilename();
        String ext = originFileName.substring(originFileName.lastIndexOf("."));
        String savedName = UUID.randomUUID() + ext;
        String fileFullPath = Paths.get(filePath, savedName).toString();

        /* 파일 저장 */
        try {
            singleFile.transferTo(new File(filePath + "/" + savedName));
            model.addAttribute("message", "파일 업로드 완료!");
            System.out.println("파일 업로드 완료!");
        } catch (IOException e) {
            model.addAttribute("message", "파일 업로드 실패!");
            System.out.println("파일 업로드 실패!!!");
            System.out.println(fileFullPath);
        }
        return "result";
    }

    /*
     * 에디터 이미지 업로드
     * @param image 파일 객체
     * @return 업로드된 파일명
     */
    @PostMapping("/editer-image-upload")
    public String uploadEditorImage(@RequestParam MultipartFile image) {

        if (image.isEmpty()) {
            return "";
        }

        System.out.println("image : " + image);

        /* 서버로 전달된 File을 서버에서 설정하는 경로에 저장한다. */
        String root = "src/main/resources/static";
        String filePath = root + "/uploadFiles";
        File dir = new File(filePath);
        System.out.println(dir.getAbsolutePath());

        if(!dir.exists()) dir.mkdir();

        /* 파일명 변경 처리 */
        String originFileName = image.getOriginalFilename();
        String ext = originFileName.substring(originFileName.lastIndexOf("."));
        String savedName = UUID.randomUUID() + ext;
        String fileFullPath = Paths.get(filePath, savedName).toString();

        /* 파일 저장 */
        try {
            image.transferTo(new File(filePath + "/" + savedName));
//            model.addAttribute("message", "파일 업로드 완료!");
            System.out.println("파일 업로드 완료!");
        } catch (IOException e) {
//            model.addAttribute("message", "파일 업로드 실패!");
            System.out.println("파일 업로드 실패!");
            System.out.println(fileFullPath);
        }
//        return "result";
        return savedName;
    }

    @GetMapping(value = "/editer-image-print", produces = { MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE })
    public byte[] printEditorImage(@RequestParam final String filename) {

        String root = "src/main/resources/static";
        String filePath = root + "/uploadFiles";
        String fileFullPath = Paths.get(filePath, filename).toString();

        // 파일이 없는 경우 예외 throw
        File uploadedFile = new File(fileFullPath);
        if (!uploadedFile.exists()) {
            throw new RuntimeException();
        }

        try {
            // 이미지 파일을 byte[]로 변환 후 반환
            byte[] imageBytes = Files.readAllBytes(uploadedFile.toPath());
            return imageBytes;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }





//    @PostMapping("/multi-file")
//    public String multiFileUpload(@RequestParam String multiFileDescription,
//                                   @RequestParam List<MultipartFile> multiFile,
//                                   Model model) {
//
//        System.out.println("multiFileDescription : " + multiFileDescription);
//        System.out.println("multiFile : " + multiFile);
//
//        /* 서버로 전달된 File을 서버에서 설정하는 경로에 저장한다. */
//        String root = "src/main/resources/static";
//        String filePath = root + "/uploadFiles";
//        File dir = new File(filePath);
//        System.out.println(dir.getAbsolutePath());
//
//        if(!dir.exists()) dir.mkdir();
//
//        List<FileDTO> files = new ArrayList<>();
//
//        /* 파일명 변경 처리 후 저장 : 다중 파일 반복문 처리 */
//        try {
//            for (MultipartFile file : multiFile) {
//                String originFileName = file.getOriginalFilename();
//                String ext = originFileName.substring(originFileName.lastIndexOf("."));
//                String savedName = UUID.randomUUID() + ext;
//
//                /* 파일에 관한 정보 추출 후 보관*/
//                files.add(new FileDTO(originFileName, savedName, filePath, multiFileDescription));
//
//                /* 파일 저장 */
//                file.transferTo(new File(filePath + "/" + savedName));
//            }
//            /* 서버의 정해진 경로로 파일 저장이 완료되면 List<FileDTO> 타입의 객체에 저장된 정보를 DB에 insert한다. */
//            model.addAttribute("message", "파일 업로드 완료!");
//        } catch (IOException e) {
//            /* 파일 저장 중간에 실패 시 이전에 저장 된 파일 삭제 */
//            for(FileDTO file : files) {
//                new File(filePath + "/" + file.getSavedName()).delete();
//            }
//            model.addAttribute("message", "파일 업로드 실패!");
//        }
//        return "result";
//    }
}
