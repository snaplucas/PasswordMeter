package port.adapter.entrypoints;

import application.dto.PasswordDto;
import application.interfaces.IPasswordAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/password")
public class PasswordController {

    private final IPasswordAppService passwordAppService;

    @Autowired
    public PasswordController(IPasswordAppService passwordAppService) {
        this.passwordAppService = passwordAppService;
    }

    @PostMapping
    public ResponseEntity<PasswordDto> avaliarPassword(@RequestBody(required = false) final String password) {
//        if (StringUtils.isNotEmpty(password)) {
        PasswordDto passwordDto = passwordAppService.avaliarPassword(password);
        return new ResponseEntity<>(passwordDto, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.PRECONDITION_REQUIRED);
    }
}
