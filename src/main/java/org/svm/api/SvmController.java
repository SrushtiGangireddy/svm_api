package org.svm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;
import java.util.HashMap;

@RestController
public class SvmController {
    @Autowired
    private VendingService vendingService;

    @CrossOrigin(origins = "https://svm-web-262622.appspot.com")
    @GetMapping("/")
    public HashMap<String, Object> home() {
        HashMap<String, Object> response = new HashMap<>();
        response.put("Balance", vendingService.getBalance());
        response.put("Soda Selected", vendingService.getSodaSelection());
        response.put("Change", vendingService.getChange());
        response.put("Soda List", vendingService.getAllSodas());
        response.put("Machine state", vendingService.getState());
        return response;
    }

    @CrossOrigin(origins = "https://svm-web-262622.appspot.com")
    @GetMapping(value="/insertAmount/{amount}/{quantity}")
    public HashMap<String, Object> insertAmount(@PathVariable String amount, @PathVariable int quantity) {
        vendingService.insertMoney(amount, quantity);
        HashMap<String, Object> response = new HashMap<>();
        response.put("Balance", vendingService.getBalance());
        response.put("Soda Selected", vendingService.getSodaSelection());
        response.put("Change", vendingService.getChange());
        response.put("Soda List", vendingService.getAllSodas());
        response.put("Machine state", vendingService.getState());
        return response;
    }

    @CrossOrigin(origins = "https://svm-web-262622.appspot.com")
    @GetMapping(value="/dispenseSoda/{sodaId}")
    public HashMap<String, Object> dispenseSoda(@PathVariable int sodaId) {
        vendingService.setSodaSelection(sodaId);
        vendingService.dispenseSoda();
        HashMap<String, Object> response = new HashMap<>();
        response.put("Balance", vendingService.getBalance());
        response.put("Soda Selected", vendingService.getSodaSelection());
        response.put("Change", vendingService.getChange());
        response.put("Soda List", vendingService.getAllSodas());
        response.put("Machine state", vendingService.getState());
        return response;
    }

    @CrossOrigin(origins = "https://svm-web-262622.appspot.com")
    @GetMapping(value="/returnChange")
    public HashMap<String, Object> returnChange() {
        vendingService.returnChange();
        HashMap<String, Object> response = new HashMap<>();
        response.put("Balance", vendingService.getBalance());
        response.put("Soda Selected", vendingService.getSodaSelection());
        response.put("Change", vendingService.getChange());
        response.put("Soda List", vendingService.getAllSodas());
        response.put("Machine state", vendingService.getState());
        return response;
    }

    @CrossOrigin(origins = "https://svm-web-262622.appspot.com")
    @GetMapping(value="/selectSoda/{id}")
    public HashMap<String, Object> selectSoda(@PathVariable("id") int id) {
        vendingService.setSodaSelection(id);
        HashMap<String, Object> response = new HashMap<>();
        response.put("Balance", vendingService.getBalance());
        response.put("Soda Selected", vendingService.getSodaSelection());
        response.put("Change", vendingService.getChange());
        response.put("Soda List", vendingService.getAllSodas());
        response.put("Machine state", vendingService.getState());
        return response;
    }

    @CrossOrigin(origins = "https://svm-web-262622.appspot.com")
    @GetMapping(value = "/getAvailability")
    public HashMap<String, Object> getAvailability() {
        HashMap<String, Object> response = new HashMap<>();
        response.put("Soda List", vendingService.getAllSodas());
        return response;
    }
}
