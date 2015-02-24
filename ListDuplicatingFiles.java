/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listduplicatingfiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author eli
 */
public class ListDuplicatingFiles {

    public void listDuplicatingFiles(Path dir) {
        File myFile = dir.toFile();
        List<File> nonDuplicated = new LinkedList<File>();

        for (File fileEntry : myFile.listFiles()) {
            if (fileEntry.isDirectory()) {

                System.out.println(fileEntry.getName());
                listDuplicatingFiles(fileEntry.toPath());

            } else {
                if (!isDuplicated(nonDuplicated, fileEntry)) {
                    nonDuplicated.add(fileEntry);
                }
                //System.out.println(fileEntry.getName());
            }
        }

        for (File file : nonDuplicated) {
            System.out.println(file);
        }

    }

    public boolean isDuplicated(List<File> list, File file) {
        for (File check : list) {
            try {
                if (FileUtils.contentEquals(check, file)) {
                    return true;
                }
            } catch (IOException ex) {
                Logger.getLogger(ListDuplicatingFiles.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListDuplicatingFiles l = new ListDuplicatingFiles();
        Path myPath = Paths.get("/home/eli/eli");
        l.listDuplicatingFiles(myPath);

    }

}
