package ch.admin.bazg.boga.testhelper.ui.util.tasks;

import ch.admin.bazg.boga.testhelper.Logger;
import ch.admin.bazg.boga.testhelper.domainhelper.WvsHelper;
import ch.admin.bazg.boga.testhelper.ui.pages.BasePage;
import ch.admin.bazg.boga.testhelper.ui.util.CheckUiFields;
import org.junit.Assert;
import zipkin2.Call;

import java.io.IOException;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class CheckOnUiTask extends TimerTask {

    private final long maxDurationInMillis;
    private final long startTime;
    private final Timer timer;
    private AtomicBoolean isDone = new AtomicBoolean(false);
    public AtomicBoolean uiTestSuccess = new AtomicBoolean(true);
    protected CheckUiFields checkUiFields;
    private final BasePage page;

    /**
     * @param maxDurationInMillis: for how long should we let the TimerTask be running
     * */
    public CheckOnUiTask(final long maxDurationInMillis, final Timer timer, final BasePage page){
        this.maxDurationInMillis = maxDurationInMillis;
        this.startTime = System.currentTimeMillis();
        this.timer = timer;
        this.page = page;
    }

    @Override
    public void run() {
        //time limit to wait is reached, test will fail. Check if selector xpath is correct
        if(System.currentTimeMillis() >= startTime+ maxDurationInMillis) {
            //this.cancel(); -> this will stop the run() method but not the thread. to stop the entire thread, cancel the timer instance and purge it. in the end, return
            this.timer.cancel();
            this.timer.purge();
            this.isDone.set(true);
            this.uiTestSuccess.set(false);
            Logger.logStep("!!!!!!!!!!max duration of UI check exceeded, test will fail!!!!!!!!!!!!!!");
            return;
        }

        try {
            if(this.checkUiFields.checkIfUiFieldsContainExpectedValues(this.page)){
                this.timer.cancel();
                this.timer.purge();
                this.isDone.set(true);
                Logger.logStep("everything ok with UI check, proceed with backend checks");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isDone(){
        return this.isDone.get();
    }

    public boolean isUiTestSuccessful(){
        return this.uiTestSuccess.get();
    }
}
