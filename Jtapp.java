import java.io.*;

/**
 *
 * Crear JAR:
 * jar -cf fichero.jar *.class
 * Extraer manifiest
 * jar -xf fichero.jar META-INF/MANIFEST.MF
 * Anadir a Manifiesto:
 * Main-Class: claseMain
 * Generar JAR definitivo
*  jar cfm fichero.jar META-INF/MANIFEST.MF *.class
* 
**/

public class Jtapp{
	public static void main(String args[]){	
		Processor p;
		switch (args.length){
			case 0: 					
			case 1: 
			case 2:
			case 3: usage();
					break;
			case 4: 
					p = new Processor(args[0],args[1],args[2],args[3]);
					p.process();
					break;
		}

		p = null;					
	}


	public static void usage(){
		System.out.println("*******************************************************************************");
		System.out.println("*                             |     USAGE    |                                *");
		System.out.println("*******************************************************************************");
		System.out.println("* $java Jtapp \"source_file\" \"target_file\" \"pre-string\" \"post-string\"  *");
		System.out.println("*                                                                             *");
		System.out.println("*******************************************************************************");
		System.out.println("*******************************************************************************");
		System.out.println("*                             |    EXAMPLE   |                                *");
		System.out.println("*******************************************************************************");
		System.out.println("*                                                                             *");
		System.out.println("* $	java Jtapp \"s.html\" \"t.sql\" \"htp.print('\" \"');\"                   *");
		System.out.println("*                                                                             *");
		System.out.println("*******************************************************************************");
		System.out.println("*******************************************************************************");
	}
}

class Processor{

	// Variables to read from and write to a file
	private File file;
	private BufferedReader in;
	private String line;
	private FileWriter fstream;
	private BufferedWriter out;

	// File location variables
    private String source;
    private String target;
    private String pre;
    private String post;

	public Processor(String source_, String target_, String pre_, String post_){
 		this.source = source_;
 		this.target = target_;
 		this.pre = pre_;
 		this.post = post_;
	}

    // Append lines to the file
	public void process(){
		try{
			this.file = new File(this.source);			
			this.fstream = new FileWriter(target);
			this.out = new BufferedWriter(this.fstream);
			this.in = new BufferedReader(new FileReader(this.file));
						
            while(in.ready()){
            	line = in.readLine();
            	line = this.pre + this.line + this.post + "\r\n";
            	this.out.write(this.line);
            //	System.out.println(this.line);            
            }
            this.out.close();
            
		}catch(IOException e){System.out.println("Exception " + e);}

	}



}
