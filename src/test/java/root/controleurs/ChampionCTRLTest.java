package root.controleurs;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import net.minidev.json.JSONObject;
import root.repository.ChampionRepository;

// Class Test
// Cycle de vie des methodes et objet
// Ordre d'execution des tests
// Simulation de requête HTTP, les entrées et sorties des données
// Tag
// Description du test
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
@Tag("ChampionCTRLTest")
@DisplayName("Ajout champion")
class ChampionCTRLTest {

	@Autowired
	private ChampionRepository ChampRepo;

	@Autowired
	private MockMvc mvc;

	private JSONObject json;

//	@BeforeAll
//	@AfterAll
//	public void clearDatabase() {
//		this.ChampRepo.deleteAll();
//		json = null;
//	}

	@Test
	@Order(value = 1)
	@DisplayName("Nom lettre")
	public void testPostChamp() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.post("/yagAPI/post/champion/add")
				.header("Authorization", "Bearer 1b06de66-764d-42ac-a9cd-cdba6d80f0c5").content(

						"{\r\n" + "  \"nom\": \"garcia\",\r\n" + "  \"keyRiot\": \"93270\",\r\n"
								+ "  \"categorieCollection\": [\r\n" + "    {\r\n" + "      \"idCategorie\": 3,\r\n"
								+ "      \"nom\": \"Nobrain\"\r\n" + "    },\r\n" + "    {\r\n"
								+ "      \"idCategorie\": 5,\r\n" + "      \"nom\": \"Bagarre\"\r\n" + "    }\r\n"
								+ "  ]\r\n" + "}")
				.contentType(MediaType.APPLICATION_JSON))

				.andDo(print())
				.andExpect(jsonPath("$.nom", is("garcia")))
				.andExpect(jsonPath("$.keyRiot", is(93270)));

	}
	
	@Test
	@Order(value = 2)
	@DisplayName("Nom chiffre")
	public void testPostChampChiffre() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.post("/yagAPI/post/champion/add")
				.header("Authorization", "Bearer 1b06de66-764d-42ac-a9cd-cdba6d80f0c5").content(

						"{\r\n" + "  \"nom\": \"3\",\r\n" + "  \"keyRiot\": \"22222\",\r\n"
								+ "  \"categorieCollection\": [\r\n" + "    {\r\n" + "      \"idCategorie\": 3,\r\n"
								+ "      \"nom\": \"Nobrain\"\r\n" + "    },\r\n" + "    {\r\n"
								+ "      \"idCategorie\": 5,\r\n" + "      \"nom\": \"Bagarre\"\r\n" + "    }\r\n"
								+ "  ]\r\n" + "}")
				.contentType(MediaType.APPLICATION_JSON))

				.andDo(print())
				.andExpect(jsonPath("$.nom", is("22222")))
				.andExpect(jsonPath("$.keyRiot", is(93210)));

	}
	
	@Test
	@Order(value = 3)
	@DisplayName("Nom lettre et caractere speciaux")
	public void testPostChampCaractSpe() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.post("/yagAPI/post/champion/add")
				.header("Authorization", "Bearer 1b06de66-764d-42ac-a9cd-cdba6d80f0c5").content(

						"{\r\n" + "  \"nom\": \"toto/+\",\r\n" + "  \"keyRiot\": \"33333\",\r\n"
								+ "  \"categorieCollection\": [\r\n" + "    {\r\n" + "      \"idCategorie\": 3,\r\n"
								+ "      \"nom\": \"Nobrain\"\r\n" + "    },\r\n" + "    {\r\n"
								+ "      \"idCategorie\": 5,\r\n" + "      \"nom\": \"Bagarre\"\r\n" + "    }\r\n"
								+ "  ]\r\n" + "}")
				.contentType(MediaType.APPLICATION_JSON))

				.andDo(print())
				.andExpect(jsonPath("$.nom", is("toto/+")))
				.andExpect(jsonPath("$.keyRiot", is(33333)));

	}
	
	@Test
	@Order(value = 4)
	@DisplayName("Nom vide")
	public void testPostChampVide() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.post("/yagAPI/post/champion/add")
				.header("Authorization", "Bearer 1b06de66-764d-42ac-a9cd-cdba6d80f0c5").content(

						"{\r\n" + "  \"nom\": \"\",\r\n" + "  \"keyRiot\": \"4950\",\r\n"
								+ "  \"categorieCollection\": [\r\n" + "    {\r\n" + "      \"idCategorie\": 3,\r\n"
								+ "      \"nom\": \"Nobrain\"\r\n" + "    },\r\n" + "    {\r\n"
								+ "      \"idCategorie\": 5,\r\n" + "      \"nom\": \"Bagarre\"\r\n" + "    }\r\n"
								+ "  ]\r\n" + "}")
				.contentType(MediaType.APPLICATION_JSON))

				.andDo(print())
				.andExpect(jsonPath("$.nom", is("")))
				.andExpect(jsonPath("$.keyRiot", is(4950)));

	}

}
