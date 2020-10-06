package pl.plenczewski.voicesystem.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.plenczewski.voicesystem.model.GlobalProject;
import pl.plenczewski.voicesystem.model.Inhabitant;
import pl.plenczewski.voicesystem.model.LocalProject;
import pl.plenczewski.voicesystem.model.Zone;
import pl.plenczewski.voicesystem.repostory.GlobalProjectRepository;
import pl.plenczewski.voicesystem.repostory.InhabitantRepository;
import pl.plenczewski.voicesystem.repostory.LocalProjectRepository;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class PrepareTestData {

    private final static Logger LOGGER = Logger.getLogger(PrepareTestData.class.getName());

    private GlobalProjectRepository globalProjectRepository;
    private LocalProjectRepository localProjectRepository;
    private InhabitantRepository inhabitantRepository;

    @Autowired
    public PrepareTestData(GlobalProjectRepository globalProjectRepository, LocalProjectRepository localProjectRepository, InhabitantRepository inhabitantRepository) {
        this.globalProjectRepository = globalProjectRepository;
        this.localProjectRepository = localProjectRepository;
        this.inhabitantRepository = inhabitantRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void prepareTestData(){
        try{
            inhabitantRepository.save(createInhabitant());
            inhabitantRepository.save(createInhabitant2());
            for (int i = 0; i < 10; i++) {
                globalProjectRepository.save(createAndGetOneGlobalProject());
                LOGGER.log(java.util.logging.Level.FINE, "One Global Project Added");
                localProjectRepository.save(createAndGetOneLocalProject());
                LOGGER.log(java.util.logging.Level.FINE, "One Local Project Added");
            }

        }catch (Exception e){
            LOGGER.log(Level.WARNING, e.toString());
        }
    }

    private LocalProject createAndGetOneLocalProject() {
        LocalProject localProject = new LocalProject();
        localProject.setTitle("Tytul lokalny Tytul lokalny Tytul lokalny Tytul lokalny Tytul lokalny Tytul lokalny Tytul lokalny Tytul lokalny Tytul lokalny");
        localProject.setDeadLine(LocalDate.of(2020,11,30));
        localProject.setTotalCost(new Float("1001.21"));
        localProject.setZone(Zone.ZONE_1);
        return localProject;
    }

    private GlobalProject createAndGetOneGlobalProject() {
        GlobalProject globalProject = new GlobalProject();
        globalProject.setTitle("Tytul pierwszy 1 Tytul pierwszy 1 Tytul pierwszy 1 Tytul pierwszy 1 Tytul pierwszy 1 ");
        globalProject.setDeadLine(LocalDate.of(2020,12,30));
        globalProject.setTotalCost(new Float("1000.21"));

        return globalProject;
    }
    private Inhabitant createInhabitant(){
        Inhabitant inhabitant = new Inhabitant();
        inhabitant.setName("Pawel");
        inhabitant.setSurname("Lenczewski");
        inhabitant.setHomeNumber("16J");
        inhabitant.setStreet("Sobieskiego");
        inhabitant.setLocalNumber("41");
        return inhabitant;
    }
    private Inhabitant createInhabitant2(){
        Inhabitant inhabitant = new Inhabitant();
        inhabitant.setName("Marek");
        inhabitant.setSurname("Lenczewski");
        inhabitant.setHomeNumber("16J");
        inhabitant.setStreet("Sobieskiego");
        inhabitant.setLocalNumber("41");
        return inhabitant;
    }
}
