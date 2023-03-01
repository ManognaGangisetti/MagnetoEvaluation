package MagnetoTest;

import MagnetoBase.MagnetoBaseaPage;
import MagnetoLogin.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

public class MagnetoExecution extends MagnetoBaseaPage {

    MagnetoLogindetail magnetoLogindetail;
   MagnetoHomepage magnetoHomepage;
   MagnetoWishlist magnetoWishlist;


   ShippingAddressPage shippingAddressPage;
    @Test
    public void execute() throws InterruptedException, IOException, ParseException {
        magnetoLogindetail = new MagnetoLogindetail(driver);
        magnetoHomepage = new MagnetoHomepage(driver);
        magnetoWishlist = new MagnetoWishlist(driver);
        shippingAddressPage = new ShippingAddressPage(driver);

        magnetoLogindetail.enteringdetails();
        magnetoLogindetail.login();
        magnetoHomepage.clickongear();
        magnetoHomepage.pricelist();
        magnetoWishlist.clickonwishlist();
        magnetoWishlist.clickingoncart();
        shippingAddressPage.fillShippingAddress();
        shippingAddressPage.clickONNext();

        shippingAddressPage.clickONPlaceorder();
        shippingAddressPage.orderID();
        shippingAddressPage.orderidVerify();
    }
    }


