package io.github.robwin.swagger2markup.petstore;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import io.github.robwin.markup.builder.MarkupLanguage;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.http.MediaType;
import org.springframework.restdocs.config.RestDocumentationConfigurer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import springfox.documentation.staticdocs.Swagger2MarkupResultHandler;
import demo.DemoApplication;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DemoApplication.class, loader = SpringApplicationContextLoader.class)
public class Swagger2MarkupTest {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
				.apply(new RestDocumentationConfigurer()).build();
	}

	@Test
	public void convertSwaggerToAsciiDoc() throws Exception {
		this.mockMvc
				.perform(get("/v2/api-docs").accept(MediaType.APPLICATION_JSON))
				.andDo(Swagger2MarkupResultHandler.outputDirectory(
						"src/docs/asciidoc/generated").build())
				.andExpect(status().isOk());
	}

	@Test
	public void convertSwaggerToMarkdown() throws Exception {
		this.mockMvc
				.perform(get("/v2/api-docs").accept(MediaType.APPLICATION_JSON))
				.andDo(Swagger2MarkupResultHandler
						.outputDirectory("src/docs/markdown/generated")
						.withMarkupLanguage(MarkupLanguage.MARKDOWN).build())
				.andExpect(status().isOk());
	}

}
