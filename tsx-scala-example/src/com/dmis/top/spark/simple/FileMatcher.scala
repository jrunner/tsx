package com.dmis.top.spark.simple

/**
 * aiker
 * 2015/1/14
 */
object FileMatpcher {
  private def fileHere = (new java.io.File("D:\\codes\\codeall\\idea-spark\\SparkSimple\\src\\com\\dmis\\top\\spark\\simple")).listFiles()

  //根据文件后缀查询
  def filesEnding(query: String) =
    filesMatching(_.endsWith(query))

  //根据关键字查询文件
  def filesContains(query: String) =
    filesMatching(_.contains(query))

  //根据正则表达式查询文件
  def filesRegex(query: String) =
    filesMatching(_.matches(query))

  def filesMatching(matcher: String => Boolean) =
    for (file <- fileHere; if matcher(file.getName))
    yield file

  def main(args: Array[String]) {
    //    var files = filesEnding(".scala");
    //    files.foreach(println _)

    //    var files = filesContains("Simple");
    //    files1.foreach(println _)

    var files = filesRegex(".*Fall.*");
    files.foreach(println _)
  }
}
