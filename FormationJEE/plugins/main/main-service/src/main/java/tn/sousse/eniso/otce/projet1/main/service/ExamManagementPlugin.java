package tn.sousse.eniso.otce.projet1.main.service;

import java.util.List;
import net.vpc.app.vainruling.core.service.CorePlugin;
import net.vpc.app.vainruling.core.service.plugins.VrPlugin;
import net.vpc.app.vainruling.core.service.plugins.Install;
import net.vpc.app.vainruling.core.service.plugins.Start;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.logging.Logger;
import net.vpc.app.vainruling.plugins.academic.service.model.current.AcademicCourseLevel;
import net.vpc.app.vainruling.plugins.academic.service.model.current.AcademicCoursePlan;
import net.vpc.upa.UPA;
import tn.sousse.eniso.otce.projet1.main.model.Personne;

/**
 * Plugin (Module) Main for application
 *
 * @author ghofrane
 */
@VrPlugin
public class ExamManagementPlugin {

    private static final Logger log = Logger.getLogger(ExamManagementPlugin.class.getName());

    @Autowired
    private CorePlugin core;

    /**
     * module installation process. Called on application startup when the
     * plugin is first bundled (as dependency) or when a new version is bundled
     */
    @Install
    private void onInstall() {
        //configure CMS properties
        core.setAppProperty("System.App.Description", null, "prj-1");
        core.setAppProperty("System.App.Keywords", null, "prj-1");
        core.setAppProperty("System.App.Title.Major.Main", null, "prj-1");
        core.setAppProperty("System.App.Title.Major.Secondary", null, "app");
        core.setAppProperty("System.App.Title.Minor.Main", null, "prj-1");
        core.setAppProperty("System.App.Title.Minor.Secondary", null, "app");
        core.findOrCreateAppDepartment("D", "D", "Department");
        core.findOrCreateArticleDisposition("Services", "Services", "Services");
    }

    /**
     * module initialization process. Called on each application startup (after
     * @Install phase methods if any)
     */
    @Start
    private void onStart() {
    }

    public Personne inscription(String nom, String email) {
        Personne p = new Personne();
        p.setEmail(email);
        p.setFirstName(nom);
//DAO :: insert into Personne
        UPA.getPersistenceUnit().persist(p);
        return p;
    }

    public void killAllPersonneByEmailDomain(String nom) {
        List<Personne> p = UPA.getPersistenceUnit()
                .createQuery("select x from Personne x where x.email like : v")
                .setParameter("v", "%@eniso.u-sousse.tn")
                .getResultList();
        for (Personne personne : p) {
//Delete
            UPA.getPersistenceUnit().remove(personne);
        }
    }

    public Personne updateEmail(String nom, String email) {
        Personne p = UPA.getPersistenceUnit().findByField(Personne.class, "firstName", nom);
        p.setEmail(email);
//DOA::update into Personne
        UPA.getPersistenceUnit().merge(p);
        return p;
    }

    public List<AcademicCoursePlan> findCoursePlansByLevel(String courseLevelCode) {

        return UPA.getPersistenceUnit().createQuery("select x from AcademicCoursePlan where x.courseLevel.name=:courseLevelCode")
                .setParameter("courseLevelCode", courseLevelCode)
                .getResultList();

    }
public List<AcademicCourseLevel> findAcademicCourseLevels(){
return UPA.getPersistenceUnit().findAll(AcademicCourseLevel.class);
}
}
