package asimov.nsdexample;

import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Crear extends AppCompatActivity {

    NsdHelper nsdHelper;
    NsdManager.RegistrationListener registrationListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);
        nsdHelper = new NsdHelper(this);
    }

   public void onClick_crea(View v){
        EditText nombre = (EditText)findViewById(R.id.nombre_partida);
       NsdServiceInfo serviceInfo = new NsdServiceInfo();
       serviceInfo.setServiceName(nombre.getText().toString());
       serviceInfo.setServiceType("_http._tcp.");
       serviceInfo.setPort(0);
       Log.d("JAIME","Creado el registr del servicio");
   }

    public void initializeRegistrationListener() {
         mRegistrationListener = new NsdManager.RegistrationListener() {

            @Override
            public void onServiceRegistered(NsdServiceInfo NsdServiceInfo) {
                // Save the service name.  Android may have changed it in order to
                // resolve a conflict, so update the name you initially requested
                // with the name Android actually used.
                mServiceName = NsdServiceInfo.getServiceName();
            }

            @Override
            public void onRegistrationFailed(NsdServiceInfo serviceInfo, int errorCode) {
                // Registration failed!  Put debugging code here to determine why.
            }

            @Override
            public void onServiceUnregistered(NsdServiceInfo arg0) {
                // Service has been unregistered.  This only happens when you call
                // NsdManager.unregisterService() and pass in this listener.
            }

            @Override
            public void onUnregistrationFailed(NsdServiceInfo serviceInfo, int errorCode) {
                // Unregistration failed.  Put debugging code here to determine why.
            }
        };
    }

}
