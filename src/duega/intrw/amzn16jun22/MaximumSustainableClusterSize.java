package duega.intrw.amzn16jun22;


import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;


public class MaximumSustainableClusterSize {
	
	static class Result {

	    /*
	     * Complete the 'findMaximumSustainableClusterSize' function below.
	     *
	     * The function is expected to return an INTEGER.
	     * The function accepts following parameters:
	     *  1. INTEGER_ARRAY processingPower
	     *  2. INTEGER_ARRAY bootingPower
	     *  3. LONG_INTEGER powerMax
	     */

	    public static int findMaximumSustainableClusterSize(List<Integer> processingPower, List<Integer> bootingPower, long powerMax) {
	    
	        int rc = 0;
	        for(int k=2; k<=processingPower.size(); k++) {
	            int maxPwr  = 0;
	            int i = 0;
	            int j = i+k-1;
	            int Pwr  = 0;
	            while(j<processingPower.size()) {
	                int maxBoot = Integer.MIN_VALUE;
	                int sumProcessingPwr = 0;
	                for(int p = i; p<=j ; p++){
	                    sumProcessingPwr += processingPower.get(p);
	                    maxBoot = Math.max(maxBoot, bootingPower.get(p));
	                } 
	                Pwr = sumProcessingPwr*k+maxBoot;
	                if(Pwr <= powerMax && Pwr > maxPwr) {
	                    maxPwr = Pwr;
	                    rc  = k;
	                }
	                i++;
	                j++;
	            }
	            
	            
	        }
	        return rc;
	    }
	    
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int processingPowerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> processingPower = IntStream.range(0, processingPowerCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int bootingPowerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> bootingPower = IntStream.range(0, bootingPowerCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        long powerMax = Long.parseLong(bufferedReader.readLine().trim());

        int result = Result.findMaximumSustainableClusterSize(processingPower, bootingPower, powerMax);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

