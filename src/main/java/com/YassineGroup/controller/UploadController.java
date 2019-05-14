package com.YassineGroup.controller;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Controller
public class UploadController {

    //Save the uploaded file to this folder
    //private static String UPLOADED_FOLDER = "resources";
    public static final String uploadingDir = "uploadingDir/";

    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @PostMapping("/upload")
    // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload. The uploaded file is empty.");
            return "redirect:uploadStatus";
        }
        try {
            // Clean the Directory before put new File
            FileUtils.cleanDirectory(new File(uploadingDir));

            // Get the file and save it somewhere
            String filename = file.getOriginalFilename();

            // take Content of the File
            byte[] bytes = file.getBytes();
            Path path = Paths.get(uploadingDir, filename).normalize();
            // make the File in the suitable Path
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded The Graph'" + filename + "!");

            try (Stream<String> stream = Files.lines(path)) {
                //stream.forEach(System.out::println);
                if (Character.isDigit(stream.spliterator().characteristics())) {
                    int color = Character.getNumericValue((stream.spliterator().characteristics()));
                    System.out.println("c+++++++++++ ++++++++++olor: " + color);
                }

                System.out.println("************* ++++++++++++++ +++++++++++ ");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message",
                    "You mistake uploaded '" + file.getName() + "'");
        }
        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

}