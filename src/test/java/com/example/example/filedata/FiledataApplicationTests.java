package com.example.example.filedata;

import com.example.example.filedata.Models.File;
import com.example.example.filedata.Models.Folder;
import com.example.example.filedata.Models.User;
import com.example.example.filedata.Repository.FileRepository;
import com.example.example.filedata.Repository.FolderRepository;
import com.example.example.filedata.Repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FiledataApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	FolderRepository folderRepository;

	@Autowired
	FileRepository fileRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canCreateEcosystem() {
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
