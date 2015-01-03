object ListerApp {
  
  def main(args: Array[String]) {
    if(args.size < 2){
      println("Two arguments needed to run this application:")
      println("a directory, a word")
      System.exit(0)
    }
    val lister = new Lister(args(0),args(1))
    lister.listOfFilesContainWord().map ( e => println(e) )
    lister.listOfContentOfFilesContainWord().map ( e => println(e) )
  }

}