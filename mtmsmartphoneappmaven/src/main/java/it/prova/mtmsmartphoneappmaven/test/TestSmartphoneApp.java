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
            //testDisinstallaAppDaSmartphone(smartphoneServiceInstance, appServiceInstance);
            testRimozioneCompletaSmartphoneAssociatoADueApp(appServiceInstance, smartphoneServiceInstance);
            //testAggiornaVersioneApp(appServiceInstance);
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

    private static void testDisinstallaAppDaSmartphone(SmartphoneService smartphoneServiceInstance, AppService appServiceInstance) throws Exception {
        System.out.println(".......testDisinstallaAppDaSmartphone inizio.............");

        // 1) Prendo uno smartphone e installo un’app (se non già collegati)
        Smartphone phone = smartphoneServiceInstance.listAll().get(0);
        App app = appServiceInstance.listAll().get(0);
        Long idPhone = phone.getId();
        Long idApp = app.getId();

        // 2) Disinstallazione
        smartphoneServiceInstance.disinstallaAppDaSmartphone(idPhone, idApp);

        // 3) Ricarico
        Smartphone reloaded = smartphoneServiceInstance.caricaSingoloElementoEagerApps(idPhone);
        boolean stillLinked = reloaded.getApps().stream().anyMatch(a -> a.getId().equals(idApp));

        if (stillLinked) {
            throw new RuntimeException("testDisinstallaAppDaSmartphone fallito: app ancora presente");
        }

        System.out.println(".......testDisinstallaAppDaSmartphone fine: PASSED.............");
    }

    private static void testRimozioneCompletaSmartphoneAssociatoADueApp(
            AppService appService,
            SmartphoneService smartphoneService) throws Exception {

        System.out.println(".......testRimozioneCompletaSmartphoneAssociatoADueApp inizio.............");

        // 1) creo uno smartphone
        Smartphone phone = new Smartphone("TestBrand", "X1", 499.99, "Android 14");
        smartphoneService.inserisciNuovo(phone);
        Long idPhone = phone.getId();

        // 2) creo due app
        App app1 = new App("TestApp1", LocalDate.parse("2023-01-01"));
        App app2 = new App("TestApp2", LocalDate.parse("2023-02-02"));
        appService.inserisciNuovo(app1);
        appService.inserisciNuovo(app2);
        Long idApp1 = app1.getId();
        Long idApp2 = app2.getId();

        // 3) collego le app allo smartphone
        smartphoneService.aggiungiApp(phone, app1);
        smartphoneService.aggiungiApp(phone, app2);

        // 4) rimuovo completamente lo smartphone
        smartphoneService.rimuoviMaPrimaScollegaApps(idPhone);

        if (smartphoneService.caricaSingoloElemento(idPhone) != null) {
            throw new RuntimeException("testRimozioneCompleta fallito: smartphone ancora presente");
        }

        if (appService.caricaSingoloElemento(idApp1) == null || appService.caricaSingoloElemento(idApp2) == null) {
            throw new RuntimeException("testRimozioneCompleta fallito: una o più app cancellate");
        }

        System.out.println(".......testRimozioneCompletaSmartphoneAssociatoADueApp fine: PASSED.............");
    }

}
