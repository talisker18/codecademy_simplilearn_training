package AAA_core.classes.inner_classes.real_life_example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;


//original class: public class ProcessBuilderAndExecutor
public class InnerClassRealLiveExample {

	private String cmd = "";

    public void connectToCloudFoundryOnAbnahmeEnv(String app){

    	
        class CloudFoundryConnection{

            public static final String BOGA_APP_NAME = "Borderguard";
            public static final String INSPECZIUN_APP_NAME = "Inspecziun";

            private static final String BOGA_APP_ABN = "BAZG-Borderguard -s ABN";
            private static final String INSPECZIUN_APP_ABN = "BAZG-Inspecziun -s ABN";
            private static final String cfLoginCmd = "cf login -a https://api.cfap02.atlantica.admin.ch -o ";

            void loginToApp(String app){
                if(app.equals(BOGA_APP_NAME)){
                    cmd = cfLoginCmd+BOGA_APP_ABN;
                }else if(app.equals(INSPECZIUN_APP_NAME)){
                    cmd = cfLoginCmd+INSPECZIUN_APP_ABN;
                }
            }

            void loginToInspecziun(){

            }

            void connectToCloudFoundry(){
                createProcessAndExecuteCmd("");
            }
        }

        CloudFoundryConnection cfc = new CloudFoundryConnection();
        cfc.loginToApp(app);

        createProcessAndExecuteCmd(this.cmd);
    }

    private void createProcessAndExecuteCmd(String cmd){
        Process process = null;
        InputStream in = null;
        String resultAsText = null;

        try {
            process = Runtime.getRuntime().exec(cmd);
            Thread.sleep(3000); //wait until process has finished the execution
            in = process.getInputStream();

            //convert inputstream to String
            resultAsText = new BufferedReader(
                    new InputStreamReader(in, StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining("\n"));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            process.destroy();
        }
    }
}
