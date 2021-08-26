package br.com.awasis.manangerbackend;

import br.com.awasis.manangerbackend.configuracao.nfe.JavaNfeConfiguracao;
import br.com.awasis.manangerbackend.model.Contato;
import br.com.awasis.manangerbackend.model.Endereco;
import br.com.awasis.manangerbackend.model.Fornecedor;
import br.com.awasis.manangerbackend.model.GrupoFornecedor;
import br.com.awasis.manangerbackend.model.Produto;
import br.com.awasis.manangerbackend.model.TipoFornecedor;
import br.com.awasis.manangerbackend.repository.FornecedorRepository;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.LongStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@Configuration
public class MainClassApplication {
                
    public static void main(String[] args) {
	SpringApplication.run(MainClassApplication.class, args);
    }
        
    private static final int BCRYPT_STRENGTH = 6;
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        //https://www.browserling.com/tools/bcrypt
        return new BCryptPasswordEncoder(BCRYPT_STRENGTH);
        //return NoOpPasswordEncoder.getInstance();
    }
        /*
        @Bean
        CommandLineRunner init(FornecedorRepository repository) {
            return args -> {
                repository.deleteAll();
                LongStream.range(1, 11)
                        .mapToObj(i -> {
                            GrupoFornecedor g = new GrupoFornecedor();
                            TipoFornecedor t = new TipoFornecedor();
                            List<Contato> contatos = new ArrayList<>();
                            t.setIdTipoFornecedor(1);
                            g.setIdGrupoFornecedor(1);
                            Fornecedor f = new Fornecedor();
                            f.setContatos(contatos);
                            f.setCelular("121312312312");
                            f.setCnpj(1212121212);
                            f.setCpf(1065286994);
                            f.setDataUltimaCompra(new Date());
                            f.setInscricaoEstadual(123123123);
                            f.setPontuacao(100.0);
                            f.setRazaoSocial("teste" );
                            f.setGrupoFornecedor(g);
                            f.setTipoFornecedor(t);
                            f.setTelefoneFixo("2323213123");
                            f.setNomeFantasia("teste");
                            
                            
                            return f;
                        })
                        .map(v -> repository.save(v))
                        .forEach(System.out::println);
            };
        }
*/
}
