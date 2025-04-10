import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


// Utilisation de l'annotation pour définir l'ordre d'exécution des méthodes de test selon leur nom
@TestMethodOrder(MethodOrderer.MethodName.class)
public class test_jumia {
        static WebDriver driver; // Déclaration de la variable partagée

        // Cette méthode s'exécute une seule fois avant tous les tests
        @BeforeAll
        public static void setUp() {
            driver = new ChromeDriver(); // Initialisation du navigateur Chrome
            driver.get("https://www.jumia.ma/"); // Accès au site Jumia
            driver.manage().window().maximize(); // Maximisation de la fenêtre du navigateur

        }
        // Test pour fermer la première pop-up ( info promo)
        @Test
        public void t001_test() throws InterruptedException{
            try {
                Thread.sleep(1000); // Attente pour s'assurer du chargement
                WebElement supprimé_la_premiere_page = driver.findElement(By.cssSelector("#pop > div > section > button > svg"));
                supprimé_la_premiere_page.click(); // Fermer la pop-up

                System.out.println("Test t001_test has passed.");
            } catch (Exception e) {
                System.out.println("Test t001_test has failed.");
            }

        }
        // Test pour fermer une bannière publicitaire
        @Test
        public void t002_test() throws InterruptedException{
            try {
                Thread.sleep(1000);
                WebElement pub = driver.findElement(By.cssSelector("#jm > div.banner-pop._def > button > span > svg > use"));
                pub.click();

                System.out.println("Test t002_test has passed.");
            }catch (Exception e) {
                System.out.println("Test t002_test has failed.");
            }
        }

        // Test pour accepter les cookies
        @Test
        public void t003_test() throws InterruptedException {
            try {
                Thread.sleep(1000);
                WebElement cookie = driver.findElement(By.cssSelector("#jm > article > button"));
                cookie.click();

                System.out.println("Test t003_test has passed.");
            }catch (Exception e) {
                System.out.println("Test t003_test has failed.");
            }
        }
        // Test pour naviguer vers la catégorie "Téléphones & Tablettes"
        @Test
        public void t004_test() throws InterruptedException {
            try {
                Thread.sleep(1000);
                WebElement Catégorie = driver.findElement(By.cssSelector("#jm > main > div.row.-pvm > div.col16.-df.-j-bet.-pbs > div.flyout-w.-fsh0.-fs0 > div > a:nth-child(1) > span"));
                Catégorie.click();
                System.out.println("Test t004_test has passed.");
            }catch (Exception e) {
                System.out.println("Test t004_test has failed.");
            }

        }

        // Test pour rechercher un produit et l’ajouter au panier
        @Test
        public void t005_test() throws InterruptedException {
            try {
                Thread.sleep(1000);
                WebElement barreDeRecherche = driver.findElement(By.cssSelector("#fi-q"));
                barreDeRecherche.sendKeys("Apple iPhone 15 – 6,1\" – 128 Go – 6 Go RAM – Noir");// Saisie de la recherche
                Thread.sleep(1000);
                WebElement BoutonCherché =driver.findElement(By.cssSelector("#search > button"));
                BoutonCherché.click();
                Thread.sleep(5000);// Attente de chargement des résultats

                // Déplacement vers le produit
                Actions action = new Actions(driver);
                WebElement element = driver.findElement(By.cssSelector("#jm > main > div.aim.row.-pbm > div.-pvs.col12 > section > div.-phs.-pvxs.row._no-g._4cl-3cm-shs > article > a.core"));
                action.moveToElement(element).build().perform();

                // Ajouter au panier
                Thread.sleep(1000);
                WebElement AjoutéAuPanié = driver.findElement(By.cssSelector("#jm > main > div.aim.row.-pbm > div.-pvs.col12 > section > div.-phs.-pvxs.row._no-g._4cl-3cm-shs > article > footer > form > button"));
                AjoutéAuPanié.click();

                System.out.println("Test t005_test has passed.");
            }catch (Exception e) {
                System.out.println("Test t005_test has failed.");
            }
        }
        // Test pour augmenter la quantité du produit (peut dépendre de l’état du panier)
        @Test
        public void t006_test() throws InterruptedException {
              try {
                  Thread.sleep(1000);
                  WebElement ajout = driver.findElement(By.cssSelector("#jm > main > div.aim.row.-pbm > div.-pvs.col12 > section > div.-phs.-pvxs.row._no-g._4cl-3cm-shs > article > footer > form > button:nth-child(4)"));
                    ajout.click(); // Cliquer sur "+" pour augmenter quantité

                    System.out.println("Test t006_test has passed.");
              }catch (Exception e) {
                  System.out.println("Test t006_test has failed.");
              }
        }

       // Test pour cliquer sur le bouton "Panier"
        @Test
        public void t007_test() throws InterruptedException {
            try {
                Thread.sleep(5000);
                WebElement panier = driver.findElement(By.cssSelector("#jm > header > section > div.col.-df.-j-bet.-m.-phn.-i-ctr > a")) ;
                panier.click();
                System.out.println("Test t007_test has passed.");

            }catch (Exception e) {
                System.out.println("Test t007_test has failed.");
            }
        }
        // Test pour cliquer sur le bouton "Commander"
        @Test
        public void t008_test() throws InterruptedException {
                try {
                    Thread.sleep(2000);
                        WebElement Commender = driver.findElement(By.cssSelector("#jm > main > div > div.col4 > div > article > div.-fs0.-pas.-bt > a"));
                        Commender.click();

                        System.out.println("Test t008_test has passed.");
                }catch (Exception e) {
                    System.out.println("Test t008_test has failed.");
                }
        }
        /// ////////////////////////////////////////////////////////////////////////////
        /// /////////////////////// ici il y a un blockage /////////////////////////////
        /// /// ////////////////////////////////////////////////////////////////////////////

            // Test pour entrer un e-mail et cliquer sur "Continuer"
            @Test
            public void t009_test() throws InterruptedException {
                    try {
                        //e-mail
                        driver.findElement(By.cssSelector("#input_identifierValue")).sendKeys("test27162716@gmail.com");
                        //bouton continuer
                        driver.findElement(By.cssSelector("#identification-form > div.ctx-identification.flow-layout > div.actions > div.mdc-touch-target-wrapper > button > span.mdc-button__touch")).click();
                        System.out.println("Test t009_test has passed.");
                    }catch (Exception e) {
                        System.out.println("Test t009_test has failed.");
                    }
                }
            // Test pour entrer le mot de passe et se connecter
            @Test
            public void t010_test() throws InterruptedException {
                try {
                    // mot de passe
                    driver.findElement(By.cssSelector("input.password-input")).sendKeys("CAN.run-010203");
                    //bouton se connecter
                    driver.findElement(By.cssSelector("#loginButton > span.mdc-button__touch")).click();
                    System.out.println("Test t010_test has passed.");
                } catch (Exception e) {
                    System.out.println("Test t010_test has failed.");
                }
            }
            // Test pour remplir les informations de livraison
            @Test
            public void t011_test() throws InterruptedException {
                try {
                    // bouton ajout des informations
                    driver.findElement(By.cssSelector("#addressSelect > div:nth-child(1) > a")).click();
                    // Prenom
                    driver.findElement(By.cssSelector("#fi-firstName")).sendKeys("test");
                    // Nom
                    driver.findElement(By.cssSelector("#fi-lastName")).sendKeys("can");
                    // Numéro
                    driver.findElement(By.cssSelector("#fi-phone")).sendKeys("0660593858");
                    // Adresse
                    driver.findElement(By.cssSelector("#fi-address1")).sendKeys("Rabat-Hassan");
                    // Région dropdown
                    driver.findElement(By.cssSelector("#fi-regionId > option:nth-child(16)y")).click();
                    // Ville dropdown
                    driver.findElement(By.cssSelector("#fi-cityId > option:nth-child(2)")).click();
                    //bouton "enregistrer"
                    driver.findElement(By.cssSelector("#jm > main > form > div > button")).click();

                    System.out.println("Test t011_test has passed.");

                }catch (Exception e) {
                    System.out.println("Test t011_test has failed.");
                }
            }

        // Méthode exécutée après tous les tests pour fermer le navigateur
            @AfterAll
            public static void tearDown() {
                if (driver != null) {
                    driver.quit();
                }
            }

}
