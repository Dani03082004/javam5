package com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.stakeholders;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations.Checker;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class PersonOBJ {
    protected int id;
    protected String name;
    protected String address;
    protected String cognoms;
    protected int phoneNumber;
    protected int postalCode;
    protected String email;
    protected String birthday;

    // Hemos de tener un constructor vacio y el otro lleno
    protected PersonOBJ() {
    }

    // Todo lo que no sea abstracto, no hacer ni try ni catch
    public static PersonOBJ getInstance(int id, String name, String address, String cognoms, int phoneNumber, int postalCode,
            String email,String birthday) throws BuildException {
        StringBuilder message = new StringBuilder();
        PersonOBJ person = new PersonOBJ();

        if (!person.setId(id)) {
            message.append("Bad ID; ");
        }

        if (!person.setName(name)) {
            message.append("Bad Name; ");
        }

        if (!person.setAddress(address)) {
            message.append("Bad Address; ");
        }

        if (!person.setCognoms(cognoms)) {
            message.append("Bad Surname; ");
        }

        if (!person.setPhoneNumber(phoneNumber)) {
            message.append("Bad Phone Number; ");
        }

        if (!person.setPostalCode(postalCode)) {
            message.append("Bad Postal Code; ");
        }

        if (!person.setEmail(email)) {
            message.append("Bad Email; ");
        }

        if (!person.setBirthday(birthday)) {
            message.append("Bad Birthday; ");
        }

        // Si hay errores, lanzamos la BuildException
        if (message.length() > 0) {
            throw new BuildException("Not possible to create the object: " + message.toString());
        }
        return person;
    }

    public int getId() {
        return id;
    }

    public boolean setId(int id) {
        if (Checker.NotZeroNegative((int) id) != 0) {
            return false;
        }
        this.id = id;
        return true;
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        if (Checker.NotNullEmptyString(name) != 0) {
            return false;
        }
        if (!Checker.minLength(name, 2)) {
            return false;
        }
        this.name = name;
        return true;
    }

    public String getAddress() {
        return address;
    }

    public boolean setAddress(String address) {
        if (Checker.NotNullEmptyString(address) != 0) {
            return false;
        }
        if (!Checker.minLength(address, 2)) {
            return false;
        }
        this.address = address;
        return true;
    }

    public String getCognoms() {
        return cognoms;
    }

    public boolean setCognoms(String cognoms) {
        if (Checker.NotNullEmptyString(cognoms) != 0) {
            return false;
        }
        if (!Checker.minLength(cognoms, 5)) {
            return false;
        }
        this.cognoms = cognoms;
        return true;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public boolean setPhoneNumber(int phoneNumber) {
        if (Checker.NotZeroNegative(phoneNumber) != 0) {
            return false;
        }
        this.phoneNumber = phoneNumber;
        return true;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public boolean setPostalCode(int postalCode) {
        if (Checker.NotZeroNegative(postalCode) != 0) {
            return false;
        }
        this.postalCode = postalCode;
        return true;
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        if (!Checker.isValidEmailFormat(email)) {
            return false;
        }
        this.email = email;
        return true;
    }

    public String getBirthday() {
        return birthday;
    }

    public boolean setBirthday(String birthday) {
        if (Checker.NotNullEmptyString(birthday) != 0) {
            return false;
        }
        this.birthday = birthday;
        return true;
    }

    @Override
    public String toString() {
        return "PersonOBJ [id=" + id + ", name=" + name + ", cognoms=" + cognoms + "]";
    }

    public String getData() {
        StringBuilder mensaje_persona = new StringBuilder();
        mensaje_persona.append("ESTA ES LA INFORMACIÓN DE LA PERSONA: ");
        mensaje_persona.append("id: ").append(this.getId());
        mensaje_persona.append(", nombre: ").append(this.getName());
        mensaje_persona.append(", apellidos: ").append(this.getCognoms());
        mensaje_persona.append(", dirección: ").append(this.getAddress());
        mensaje_persona.append(", teléfono: ").append(this.getPhoneNumber());
        mensaje_persona.append(", código Postal: ").append(this.getPostalCode());
        mensaje_persona.append(", correo Electrónico: ").append(this.getEmail());
        mensaje_persona.append(", cumpleaños: ").append(this.getBirthday());
        return mensaje_persona.toString();
    }

}
