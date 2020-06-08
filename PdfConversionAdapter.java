import java.io.IOException;
import ims.keystone.microservice.pdfconversion.sdk.PdfConversionSDK;
 
/**
 * This utility is the PdfConversionAdapter that utilizes the 
 * PdfConversionSDK.
 */
public class PdfConversionAdapter {

    public static void main(String[] args) throws InterruptedException {

        String downloadDir = "/data/1/pdfConvertedDir";
        String pdfConversionURL = "http://localhost:8083/pdfConversion";

		// the first arg is the file (i.e. "/data/1/testFiles/TestDoc.docx")		
		String file = args[0];
 
        try {
			// Create PdfConversion SDK
            PdfConversionSDK pdfConversion = new PdfConversionSDK(pdfConversionURL);
            
			// Send the pdfConversion request to the Pdf Conversion service 
			// via the pdfConversion SDK
 			int jobId = pdfConversion.uploadFile(file);
            System.out.println("File: " + file + " was uploaded to PDF Converter.  Its jobId is " + jobId);

			// Get status of the pdfConversion job
            boolean finished = false;
			String result;
            while (!finished) {
    			
				result = pdfConversion.getJobStatus(jobId);
				if (result.equals("Finished")) {
                    System.out.println("Job: " + jobId + " is finished.");
					finished = true;
				} else {
                    System.out.println("Job: " + jobId + " isn't finished.");
					Thread.sleep(5000);
				}
			}

			// Job complete, get the pdfConversion result
			pdfConversion.downloadFile(jobId, downloadDir);
            System.out.println("PDF converted result for Job: " + jobId + " downloaded to " + downloadDir);
          
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
