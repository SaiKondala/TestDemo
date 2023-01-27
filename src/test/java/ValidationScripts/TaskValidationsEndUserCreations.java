package ValidationScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import central.PageObject.SCWIInstance;
import central.PageObject.SCWSInstance;
import central.PageObject.SC_WFI_Validations;
import central.TestCases.TC01_SCExtLogin;

public class TaskValidationsEndUserCreations extends TCTaskValidationsWFTCreations {

	@Test(priority = 11) // 11
	public void WSInstance() throws InterruptedException, IOException {
		SCWSInstance wsi = new SCWSInstance(driver);
		wsi.CreateWSIForValidations();
	}

	@Test(priority = 12) // 12
	public void WIInstance() {
		SCWIInstance wii = new SCWIInstance(driver);
		wii.CreateWIIforValidations();
	}

	@Test(priority = 13)
	public void Validations() throws InterruptedException {
		SC_WFI_Validations WFI = new SC_WFI_Validations(driver);
		WFI.NoResourceV1();
		WFI.AssetTaskV02();
		WFI.MandatoryMDValidation03();
		WFI.MandatoryAttachmentValidation04();
	}
}
