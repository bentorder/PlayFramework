import static play.test.Helpers.*;

import org.junit.Test;

import play.libs.F.Callback;
import play.test.TestBrowser;
public class IntegrationTest {
	@Test
	public void testTop() {
		running(testServer(3333), org.openqa.selenium.firefox.FirefoxDriver.class, new Callback<TestBrowser>() {
			public void invoke(TestBrowser browser) {
				browser.goTo("http://localhost:3333/top");
			}
		});
	}
}