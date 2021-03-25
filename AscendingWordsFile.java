package lists;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AscendingWordsFile {

	public static void main(String[] args) throws IOException {
		List<String> list = new ArrayList<String>();
		File file = new File("words.txt");
		file.createNewFile();
		FileReader reader = new FileReader(file);
		char[] arr = new char[(int) file.length()];
		reader.read(arr);
		reader.close();
		int length = arr.length;
		String temp = "";
		for (int i = 0; i < length; i++) {
			if (arr[i] == ' ') {
				list.add(temp);
				temp = "";
			} else {
				temp += arr[i];
			}
		}
		list.add(temp);
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
	}

}
