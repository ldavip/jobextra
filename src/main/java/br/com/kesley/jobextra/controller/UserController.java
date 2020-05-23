package br.com.kesley.jobextra.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.kesley.jobextra.controller.form.CreateUserForm;
import br.com.kesley.jobextra.controller.form.UpdateCompanyForm;
import br.com.kesley.jobextra.controller.form.UpdatePersonForm;
import br.com.kesley.jobextra.controller.form.UpdateUserForm;
import br.com.kesley.jobextra.model.Company;
import br.com.kesley.jobextra.model.Person;
import br.com.kesley.jobextra.model.User;
import br.com.kesley.jobextra.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "API para gerenciamento e consulta dos usuários")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    private String getPhotoPath(User user) {
        return String.format("/users/%d/photo", user.getId());
    }

    @ApiOperation("Consulta todos os usuários.")
    @GetMapping
    public ResponseEntity<List<User>> findAll(
            @RequestParam(value = "name", required = false, defaultValue = "") String name,
            UriComponentsBuilder uriBuilder) {

        List<User> users = service.findAllByName(name);

        users.forEach(user -> user.setPath(getPhotoPath(user)));

        return ResponseEntity.ok(users);
    }

    @ApiOperation("Consulta os dados de um usuário por id.")
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Integer id, UriComponentsBuilder uriBuilder) {
        User user = service.findById(id);

        user.setPath(getPhotoPath(user));

        return ResponseEntity.ok(user);
    }

    @ApiOperation("Cadastra um novo usuário.")
    @PostMapping
    public ResponseEntity<User> create(@RequestBody CreateUserForm form) {

        User user = service.create(form);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(user);
    }

    @ApiOperation("Consulta a foto de um usuário.")
    @GetMapping("/{id}/photo")
    public ResponseEntity<byte[]> getPhoto(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.getPhoto(id));
    }

    @PutMapping("/person/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") Integer id, UpdatePersonForm form) {

        Person updated = service.updatePerson(id, form);

        return ResponseEntity.ok(updated);
    }

    @PutMapping("/company/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable("id") Integer id, UpdateCompanyForm form) {

        Company updated = service.updateCompany(id, form);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
