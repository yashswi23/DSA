static void capitalizeWords(String source, String dest)
{
    try(BufferedReader reader= new BufferedReader(new FileReader(source))){
        BufferedWriter writer = new BufferedWriter(new FileWriter(dest));
        String line;
       while((line = reader.readLine())!= null){
            String[] words = line.split(" ");
            StringBuilder sb = new StringBuilder();
            for(String word: words){
                if(word.length()>0){
                    sb.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
                }
            }
            writer.write(sb.toString().trim());
            writer.newLine();
        }
        writer.close();
        
    }
    catch(IOException e){
        e.printStackTrace();
    }
  
}
