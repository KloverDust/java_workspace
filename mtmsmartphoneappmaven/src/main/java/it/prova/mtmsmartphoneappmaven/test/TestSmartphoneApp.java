package it.prova.mtmsmartphoneappmaven.test;

import it.prova.mtmsmartphoneappmaven.dao.EntityManagerUtil;
import it.prova.mtmsmartphoneappmaven.model.App;
import it.prova.mtmsmartphoneappmaven.model.Smartphone;
import it.prova.mtmsmartphoneappmaven.service.AppService;
import it.prova.mtmsmartphoneappmaven.service.MyServiceFactory;
import it.prova.mtmsmartphoneappmaven.service.SmartphoneService;

import java.time.LocalDate;

public class TestSmartphoneApp {

    public static void main(String[] args) {

        AppService appServiceInstance = MyServiceFactory.getAppServiceInstance();
        SmartphoneService smartphoneServiceInstance = MyServiceFactory.getSmartphoneServiceInstance();

        try {
            System.out.println("Inizio test...");
            System.out.println("In tabella App ci sono " + appServiceInstance.listAll().size() + " elementi.");
            System.out.println("In tabella Smartphone ci sono " + smartphoneServiceInstance.listAll().size() + " elementi.");
            //testInserimentoNuovaApp(appServiceInstance);
            //testInserimentoNuovoSmartphone(smartphoneServiceInstance);
            //testAggiornaVersioneOSTramiteID(smartphoneServiceInstance);
            //testAggiornaVersioneOSTramiteIstanza(smartphoneServiceInstance);
            testAggiornaVersioneApp(appServiceInstance);
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            EntityManagerUtil.shutdown();
        }

    }

    private static void testInserimentoNuovaApp(AppService appServiceInstance) throws Exception {
        System.out.println(".......testInserimentoNuovaApp inizio.............");

        App appInstance = new App("Candy crush", LocalDate.parse("2022-09-24"));
        appServiceInstance.inserisciNuovo(appInstance);

        if (appInstance.getId() == null)
            throw new RuntimeException("testInserimentoNuovoBrano fallito ");

        System.out.println(".......testInserimentoNuovoBrano fine: PASSED.............");
    }

    private static void testInserimentoNuovoSmartphone(SmartphoneService smartphoneServiceInstance) throws Exception {
        System.out.println(".......testInserimentoNuovoSmartphone inizio.............");

        Smartphone smartphoneInstance = new Smartphone("OnePlus", "11", 749.99, "Android 14");
        smartphoneServiceInstance.inserisciNuovo(smartphoneInstance);

        if (smartphoneInstance.getId() == null)
            throw new RuntimeException("testInserimentoNuovoSmartphone fallito ");

        System.out.println(".......testInserimentoNuovoSmartphone fine: PASSED.............");
    }

    private static void testAggiornaVersioneOSTramiteID(SmartphoneService smartphoneServiceInstance) throws Exception {
        System.out.println(".......testAggiornaVersioneOSTramiteID inizio.............");

        Smartphone smartphoneInstance = smartphoneServiceInstance.caricaSingoloElemento(1L);
        smartphoneServiceInstance.aggiornaVersioneOS(smartphoneInstance.getId(), "iOS 18");

        if (!smartphoneInstance.getVersioneOS().equals("iOS 18"))
            throw new RuntimeException("testAggiornaVersioneOSTramiteID fallito ");

        System.out.println(".......testAggiornaVersioneOSTramiteID fine: PASSED.............");
    }

    private static void testAggiornaVersioneOSTramiteIstanza(SmartphoneService smartphoneServiceInstance) throws Exception {
        System.out.println(".......testAggiornaVersioneOSTramiteIstanza inizio.............");

        Smartphone toUpdate = smartphoneServiceInstance.listAll().get(0);
        Long id = toUpdate.getId();
        String oldVersion = toUpdate.getVersioneOS();

        String nuovaVersione = "iOS 19";
        toUpdate.setVersioneOS(nuovaVersione);

        smartphoneServiceInstance.aggiornaVersioneOS(toUpdate);

        Smartphone reloaded = smartphoneServiceInstance.caricaSingoloElemento(id);

        if (!nuovaVersione.equals(reloaded.getVersioneOS())) {
            throw new RuntimeException("testAggiornaVersioneOSTramiteIstanza  fallito: atteso "
                    + nuovaVersione + " ma trovato " + reloaded.getVersioneOS());
        }

        System.out.println(".......testAggiornaVersioneOSTramiteIstanza  fine: PASSED (da "
                + oldVersion + " a " + reloaded.getVersioneOS() + ")");
    }

    private static void testAggiornaVersioneApp(AppService appServiceInstance) throws Exception {
        System.out.println(".......testAggiornaVersioneApp inizio.............");

        App appToUpdate = appServiceInstance.listAll().get(0);
        Long id = appToUpdate.getId();
        String oldVersion = appToUpdate.getVersione();
        LocalDate oldDate = appToUpdate.getDataUltimoAggiornamento();

        String nuovaVersione = "2.5.5";
        LocalDate nuovaData = LocalDate.now();
        appToUpdate.setVersione(nuovaVersione);
        appToUpdate.setDataUltimoAggiornamento(nuovaData);

        appServiceInstance.aggiornaVersioneEData(appToUpdate);

        App reloaded = appServiceInstance.caricaSingoloElemento(id);

        if (!nuovaVersione.equals(reloaded.getVersione()) || !nuovaData.equals(reloaded.getDataUltimoAggiornamento())) {
            throw new RuntimeException("testAggiornaVersioneApp fallito: atteso ["
                    + nuovaVersione + ", " + nuovaData + "] ma trovato ["
                    + reloaded.getVersione() + ", " + reloaded.getDataUltimoAggiornamento() + "]");
        }

        System.out.println(".......testAggiornaVersioneApp fine: PASSED (da ["
                + oldVersion + ", " + oldDate + "] a ["
                + reloaded.getVersione() + ", " + reloaded.getDataUltimoAggiornamento() + "])");
    }

}
