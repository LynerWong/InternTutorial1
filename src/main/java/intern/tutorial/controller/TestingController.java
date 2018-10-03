package intern.tutorial.controller;

import intern.tutorial.model.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestingController {

//    private final Logger logger = LoggerFactory.getLogger(TestingController.class);

//    @RequestMapping("/testing")

//    public void performTask(){
//        logger.debug("This is a debug message.");
//        logger.info("This is an info message.");
//        logger.warn("This is a warn message.");
//        logger.error("This is an error message.");

        //        logger.trace("A TRACE Message");
//        logger.debug("A DEBUG Message");
//        logger.warn("A WARN Message");
//        logger.error("An ERROR Message");
//********************************************************************************************************************

    //Parameter 1 (Post Method)
    @PostMapping("/post_by_param1")
    public String handleParameter(Param parameter, Model model) {


        String one = parameter.getParam1();
        String two = parameter.getParam2();
        String three = parameter.getParam3();

        return ("Parameter 1 : " + one  + "\n" + "Parameter 2 : " + two  + "\n" + "Parameter 3 : " + three);
    }
    //Parameter 2
    @RequestMapping(value ="/post_by_param2", method = RequestMethod.POST)
    public String parameter2(@RequestBody Param param, @RequestBody String p1, @RequestBody String p2, @RequestBody String p3 ){
        p1= param.getParam1();
        p2= param.getParam2();
        p3= param.getParam3();

        return("Parameter 1 " +p1 + "\n" + "Parameter 2 : "+ p2 +"\n"+ "Parameter 3 : "+p3);
    }

    //Parameter 3
    @RequestMapping(value ="/post_by_param3", method = RequestMethod.POST)
    public String parameter3(@RequestParam("param1") String paramm1, @RequestParam("param2") String paramm2, @RequestParam("param3") String paramm3){
        //System.out.println("Param : " + param);

         return("Paramater 1 : " + paramm1 + "\n" + "Parameter 2 : "+ paramm2 +"\n"+ "Parameter 3 : "+paramm3);

    }





}

