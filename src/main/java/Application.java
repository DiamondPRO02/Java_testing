import adapter.Auto;
import adapter.AutoMoso;
import adapter.AutoMosoAdapter;
import adapter.Kocsi;
import builder.Dobokocka;
import builder.KockaBuilder;
import chain_of_responsibilities.ElsoLepes;
import chain_of_responsibilities.Lepes;
import chain_of_responsibilities.MasodikLepes;
import decorator.AutoMosoSzarito;
import facade.AutoMosoFacade;
import proxy.AutoMosoProxy;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        //Builder
        Dobokocka kocka = new KockaBuilder()
                .elsoOldal(2)
                .masodikOldal(4)
                .harmadikOldal(8)
                .negyedikOldal(16)
                .otodikOldal(32)
                .hatodikOldal(64)
                .build();
        //Adabter
        Kocsi kocsi = new Kocsi("Ferearri");
        AutoMosoAdapter autoMosoAdapter = new AutoMosoAdapter(new AutoMoso());
        autoMosoAdapter.mos(kocsi);
        //Decorator
        AutoMosoSzarito autoMosoSzarito = new AutoMosoSzarito(new AutoMoso());
        autoMosoSzarito.mosEsSzarít(new Auto("Toyota"));
        //Facade
        AutoMosoFacade autoMosoFacede = new AutoMosoFacade();
        autoMosoFacede.autoMosas(new Auto("Suzuki"));
        autoMosoFacede.autoMosasEsSzaritas(new Auto("Lamburgini"));
        autoMosoFacede.kocsiMosas(kocsi);
        //Proxy
        AutoMosoProxy autoMosoProxy = new AutoMosoProxy();
        for(int i=0; i<15; i++){
            autoMosoProxy.mos(new Auto("KicsiKocsi"));
        }

        //Chain of responisbility
        List<Lepes> lepesek = Arrays.asList(new ElsoLepes(), new MasodikLepes());
        for (Lepes lepes : lepesek) {
            lepes.lep();
        }
    }
}