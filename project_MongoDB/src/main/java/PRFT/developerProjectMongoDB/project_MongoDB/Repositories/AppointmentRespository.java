package PRFT.developerProjectMongoDB.project_MongoDB.Repositories;

import PRFT.developerProjectMongoDB.project_MongoDB.model.Appointment;
import PRFT.developerProjectMongoDB.project_MongoDB.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3001")
public interface AppointmentRespository extends MongoRepository<Appointment, Long>{


    default Boolean isEmpty(){
        List<Appointment> AllAppointments= this.findAll();
        if (AllAppointments.isEmpty()){
            return true;
        }
        return false;
    }

    default Boolean UUIDExists(Long id){
        List<Appointment> AllAppointments= this.findAll();
        for (int i = 0; i < AllAppointments.size(); i++){
            Appointment newOne = AllAppointments.get(i);
            if (newOne.getAppointmentID().equals(id)){
                return true;
            }
        }
        return false;
    }
    default Long generateLong(){
        Boolean isIDThere = true;
        Long newLong = new Random().nextLong(999999);
        while (isIDThere = true){
            if (UUIDExists(newLong) == false){
                isIDThere = false;
                return newLong;
            }
            newLong = new Random().nextLong();
        }
        return newLong;
    }

//    default Appointment findByApptID(Long id){ //Returns Appointment Entity with the given AppointmenID
//        List<Appointment> AllAppointments= this.findAll();
//        for (int i = 0; i < AllAppointments.size(); i++){
//            Appointment newOne = AllAppointments.get(i);
//            if (newOne.getAppointmentID().equals(id)){
//                return newOne;
//
//            }
//        }
//        return AllAppointments.get(0); //change this to none
//    }

//    default Appointment findByEmail(String emailID){ //Returns Appointment Entity with the given AppointmenID
//        List<Appointment> AllAppointments= this.findAll();
//        for (int i = 0; i < AllAppointments.size(); i++){
//            Appointment newOne = AllAppointments.get(i);
//            if (newOne.getUserEmail().equals(emailID)){
//                return newOne;
//
//            }
//        }
//        return AllAppointments.get(0); //change this to none
//    }
//    default Boolean apptIDExists(UUID id){ //Returns True if ApptID exists in database and False otherwise
//        List<Appointment> AllAppointments= this.findAll();
//        for (int i = 0; i < AllAppointments.size(); i++){
//            Appointment newOne = AllAppointments.get(i);
//            if (newOne.getAppointmentID().equals(id)){
//                return true;
//
//            }
//        }
//        return false;
//    }

//    default void deleteByApptId(UUID id){
//        List<Appointment> AllAppointments= this.findAll();
//        for (int i = 0; i < AllAppointments.size(); i++){
//            Appointment newOne = AllAppointments.get(i);
//            if (newOne.getAppointmentID().equals(id)){
//                Appointment newOne2 = newOne;
//                this.delete(newOne2);
//            }
//        }
//    }

//    default List<Appointment> getAllExcept(UUID apptID) { // Returns all appointments except for the one that has
//        // the appointmentID that matches with the passed in UUID
//        int index2 = 0;
//        List<Appointment> AllAppointments= this.findAll();
//        for (int i = 0; i < AllAppointments.size(); i++){
//            Appointment newOne = AllAppointments.get(i);
//            if (newOne.getAppointmentID().equals(apptID)){
//                index2 = i;
//            }
//        }
//        AllAppointments.remove(index2);
//        return AllAppointments;
//    }



    }

