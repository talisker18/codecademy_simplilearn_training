package AAH_testing.awaitility;

import java.time.ZonedDateTime;

public class AwaitDemo {

	
	/*
	 * not complete code
	 * 
	 * 
	 * */
	
	@Test
	public void test() {
		
		await()

	    .atMost(10, TimeUnit.SECONDS).pollInterval(500, TimeUnit.MILLISECONDS)

	    .until(() ->

	            ManualTaskServiceHelper.checkIfTaskWithTextWasCreated(ZonedDateTime.now().minusSeconds(30),

	                    ZonedDateTime.now().plusSeconds(1), "PASSAGE_COVERAGE", declarationId.toString()));

		deleteProvider(provider.providerId);
		
		//checkIfTaskWithTextWasCreated returns Boolean
		
		
	}
	
	
	public static boolean checkIfTaskWithTextWasCreated(ZonedDateTime createdFrom, ZonedDateTime createdTo, String category, String withText) {

        String searchResultJson = searchManualTask(createdFrom, createdTo, category);

        log.info("found manual task: {}", searchResultJson);

        return searchResultJson.contains(withText);

    }
	
}
