package com.example.example.filedata.Components;


import com.example.example.filedata.Models.File;
import com.example.example.filedata.Models.Folder;
import com.example.example.filedata.Models.User;
import com.example.example.filedata.Repository.FileRepository;
import com.example.example.filedata.Repository.FolderRepository;
import com.example.example.filedata.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {


    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader() {
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = new User("Rique");
        userRepository.save(user);

        Folder folder = new Folder("documents", user);
        folderRepository.save(folder);

        File file1 = new File("file", "txt", 3, folder);
        fileRepository.save(file1);

        user.addFolders(folder);
        folder.addFile(file1);

    }
}
