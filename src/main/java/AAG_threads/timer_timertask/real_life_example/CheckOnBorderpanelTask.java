package ch.admin.bazg.boga.testhelper.ui.util.tasks;

import ch.admin.bazg.boga.testhelper.Logger;
import ch.admin.bazg.boga.testhelper.domainhelper.WvsHelper;
import ch.admin.bazg.boga.testhelper.ui.pages.BasePage;
import ch.admin.bazg.boga.testhelper.ui.pages.BorderPanelPage;
import ch.admin.bazg.boga.testhelper.ui.util.CheckUiFields;
import ch.admin.bazg.boga.testhelper.ui.util.TextsOnUi;

import java.io.IOException;
import java.util.Timer;

public class CheckOnBorderpanelTask extends CheckOnUiTask {

    /**
     * @param maxDurationInMillis : for how long should we let the TimerTask be running
     * @param timer
     */
    public CheckOnBorderpanelTask(final long maxDurationInMillis, final Timer timer, final BasePage page) {
        super(maxDurationInMillis, timer, page);
    }

    public void createAndSetCheckUiFieldsForHappyCase(final int numberOfGoodsDeclarations, final int weight, WvsHelper wvsHelper){
        super.checkUiFields= new CheckUiFields() {
            @Override
            public boolean checkIfUiFieldsContainExpectedValues(BasePage page) throws IOException {
                boolean checkedFieldsContainExpectedValue = true;

                final String plateCountryOnUi = page.findElementAndReturnItsText(BorderPanelPage.selectorTextFieldForPlateCountry);
                final String plateValueOnUi = page.findElementAndReturnItsText(BorderPanelPage.selectorTextFieldForPlateValue);
                final String decisionFromUi = page.findElementAndReturnItsText(BorderPanelPage.selectorTextFieldDecision);
                final String disabledAttributeForNextBtn = page.getAttributeValueForSpecificElement(BorderPanelPage.selectorForNextBtn,"disabled");
                final String disabledAttributeForCancelBtn = page.getAttributeValueForSpecificElement(BorderPanelPage.selectorForCancelBtn,"disabled");
                final String valueAttributeForToggle = page.getAttributeValueForSpecificElement(BorderPanelPage.selectorForToggleSwitchOperationMode,"value");
                final String goodDeclarationCounterOnUi = page.findElementAndReturnItsText(BorderPanelPage.selectorTextFieldGoodsDeclarationCounter);
                final String weightOnUi = page.findElementAndReturnItsText(BorderPanelPage.selectorTextFieldWeight);
                final String inspectionNeedsOnUi = page.findElementAndReturnItsText(BorderPanelPage.selectorTextFielInspectionNeeds);

                if(!plateCountryOnUi.equals(wvsHelper.getPlateCountryInAlpha2())){
                    checkedFieldsContainExpectedValue = false;
                    Logger.logStep("!!!!!!!!!!!!!!UI check: plateCountry does not equal to expected value!!!!!!!!!!!!!!!");
                }

                if(!plateValueOnUi.equals(wvsHelper.getPlateValue().toUpperCase())){
                    checkedFieldsContainExpectedValue = false;
                    Logger.logStep("!!!!!!!!!!!!!!UI check: plateValue does not equal to expected value!!!!!!!!!!!!!!!");
                }

                if(!decisionFromUi.equals(TextsOnUi.FREE_JOURNEY.getDecision())){
                    checkedFieldsContainExpectedValue = false;
                    Logger.logStep("!!!!!!!!!!!!!!UI check: decision does not equal to expected value!!!!!!!!!!!!!!!");
                }

                if(!disabledAttributeForNextBtn.equals("true")){
                    checkedFieldsContainExpectedValue = false;
                    Logger.logStep("!!!!!!!!!!!!!!UI check: next button does not equal to expected value!!!!!!!!!!!!!!!");
                }

                if(!disabledAttributeForCancelBtn.equals("true")){
                    checkedFieldsContainExpectedValue = false;
                    Logger.logStep("!!!!!!!!!!!!!!UI check: cancel button does not equal to expected value!!!!!!!!!!!!!!!");
                }

                if(!valueAttributeForToggle.equals("true")){
                    checkedFieldsContainExpectedValue = false;
                    Logger.logStep("!!!!!!!!!!!!!!UI check: toggle does not equal to expected value!!!!!!!!!!!!!!!");
                }

                if(!goodDeclarationCounterOnUi.equals(""+numberOfGoodsDeclarations)){
                    checkedFieldsContainExpectedValue = false;
                    Logger.logStep("!!!!!!!!!!!!!!UI check: number of declarations does not equal to expected value!!!!!!!!!!!!!!!");
                }

                if(!weightOnUi.equals(""+weight)){
                    checkedFieldsContainExpectedValue = false;
                    Logger.logStep("!!!!!!!!!!!!!!UI check: weight does not equal to expected value!!!!!!!!!!!!!!!");
                }

                if(!inspectionNeedsOnUi.equals(TextsOnUi.FREE_JOURNEY.getTextForInspectionNeeds())){
                    checkedFieldsContainExpectedValue = false;
                    Logger.logStep("!!!!!!!!!!!!!!UI check: inspection needs does not equal to expected value!!!!!!!!!!!!!!!");
                }

                //these 2 method executions will throw an exception if the elements are not located within {maxTimeWaitInSecondsForElementToBeVisible} from WaitHelper.class
                page.checkIfElementIsPresent(BorderPanelPage.selectorPictureOfVehicle);
                page.checkIfElementIsPresent(BorderPanelPage.selectorPictureOfPlate);

                return checkedFieldsContainExpectedValue;
            }
        };
    }
}
