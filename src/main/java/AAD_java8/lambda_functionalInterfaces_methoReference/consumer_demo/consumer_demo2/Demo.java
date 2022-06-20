package AAD_java8.lambda_functionalInterfaces_methoReference.consumer_demo.consumer_demo2;

/**
 * 
 * code is not complete
 * 
 * decorator pattern
 * 
 * */

public class Demo {
	
	final AnprRecord storedAnprRecord = this.anprRecordRepository.save(this.anprBundleGenerator.generateAnprRecord(anprRecord -> anprRecord.setAnprCamera(this.anprCamera)));

	 

	 

	//…..

	 

	 
	//use the consumer function to decorate the AnprRecord with the missing anprCamera (look at the setter, we are setting null)
	public AnprRecord generateAnprRecord(Consumer<AnprRecord> anprRecordDecorator) {

	        final AnprRecord anprRecord = this.randomObjectGenerator.nextObject(AnprRecord.class);

	        anprRecord.setBundleId(BUNDLE_ID);

	        anprRecord.setStationId(STATION_ID);

	        anprRecord.setCameraId(CAMERA_ID);

	        anprRecord.setOcrStatus(OCR_STATUS);

	        anprRecord.setOcrScore(OCR_SCORE);

	        anprRecord.setCameraTimestamp(LocalDateTime.now());

	        anprRecord.setPlateCountry(PlateCountry.valueOfAlpha3(PLATE_COUNTRY));

	        anprRecord.setOcrStorageId(OCR_STORAGE_ID);

	        anprRecord.setCtxStorageId(CTX_STORAGE_ID);

	        //use consumer function to set the anpr camera
	        anprRecord.setAnprCamera(null);

	 

	        if (anprRecordDecorator != null) {

	        	//set the anpr camera
	            anprRecordDecorator.accept(anprRecord); //this executes 'anprRecord -> anprRecord.setAnprCamera(this.anprCamera)' for each anprRecord, in this case for var 'anprRecord'

	        }

	 

	        return anprRecord;

	    }

}
