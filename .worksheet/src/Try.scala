object Try {
import scala.io.Source;
import java.io.File;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(104); ;

	val allFiles : List[String] = List[String]();System.out.println("""allFiles  : List[String] = """ + $show(allFiles ));$skip(409); 
  def getListOfFiles(dir: String):List[String] = {
	val d = new File(dir)
	if (d.isDirectory) {
			//d.listFiles.filter { e => e.isFile() }.map { e => e.getAbsolutePath }.toList ++ allFiles
			//d.listFiles.filter { e => e.isDirectory() }.toList.flatMap(e=>getListOfFiles(e.getAbsolutePath))
			d.listFiles.toList.flatMap(e=>getListOfFiles(e.getAbsolutePath))
		} else {
			d.getAbsolutePath::allFiles
		}
	};System.out.println("""getListOfFiles: (dir: String)List[String]""");$skip(353); 
	
	def containWord(aFile:String, word:String):Boolean = {
			val doesnotContain = false;
			val doesContain = true;
			try{
				for (line <- Source.fromFile(aFile).getLines) {
					if(line.contains(word)) {
						return doesContain
					}
				}
			}catch{
				case e: Exception=> //println(s"Can't read file $aFile")
			}
			
			doesnotContain
					
	};System.out.println("""containWord: (aFile: String, word: String)Boolean""");$skip(91); 
	
	def printAFile(aFile:String) = {
		println(Source.fromFile(aFile).getLines.mkString)
	};System.out.println("""printAFile: (aFile: String)Unit""");$skip(122); val res$0 = 
	
	getListOfFiles("/home/hongwei/workspace/ListFilesContainingWord").filter(e=>containWord(e,"Scala")).map(e=>println(e));System.out.println("""res0: List[Unit] = """ + $show(res$0));$skip(125); val res$1 = 
	
	getListOfFiles("/home/hongwei/workspace/ListFilesContainingWord").filter(e=>containWord(e,"Scala")).map(e=>printAFile(e));System.out.println("""res1: List[Unit] = """ + $show(res$1))}
  
	
	
                                                  
	
	
}
