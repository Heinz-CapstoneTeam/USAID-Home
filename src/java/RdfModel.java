/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.NodeIterator;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;

/**
 *
 * @author deepakga
 */
public class RdfModel {

    String comments = null;
    Property kingdom = null;
    Property family = null;
    Property order = null;
    Property picture = null;
    Property phylum = null;
    Property conservationStatus = null;
    Property division = null;
    Property classproperty = null;
    String searchphylum;
    String searchconservationstatus;
    String searchstring;
    String searchdivisio;
    String searchkingdom;
    String searchfamilia;
    String searchclass;
    String searchorder;
    String searchcomments;
    String searchpicture;
    String searchconstatus;
    
    Resource r = null;
    Model model = null;
    String n;

    public void doSearch(String search) {

        model = ModelFactory.createDefaultModel();
        n = "http://dbpedia.org/resource/" + search;
        model.read(n);
        //String NS = "http://www.w3.org/2000/01/rdf-schema#";
        String NS = "http://dbpedia.org/ontology/" ;
        String onto = "http://dbpedia.org/ontology/";
        r = model.getResource(n);
        System.out.println("Resource = " + r);
        Property cmnt = model.getProperty(NS + "abstract");
        System.out.println("Comment property = " + cmnt);

        kingdom = model.getProperty(onto + "kingdom");
        System.out.println("Kingdom = "  + r.getProperty(kingdom).getObject().toString());

        if (r.getProperty(kingdom).getObject().toString().contains("Plant")) {

            family = model.getProperty(onto + "family");
            order = model.getProperty(onto + "order");
            picture = model.getProperty("http://xmlns.com/foaf/0.1/depiction");


            if (r.hasProperty(model.getProperty(onto + "class"))) {

                classproperty = model.getProperty(onto + "class");

            } else if (r.hasProperty(model.getProperty("http://dbpedia.org/property/class"))) {

                classproperty = model.getProperty("http://dbpedia.org/property/class");
            }


            if (r.hasProperty(model.getProperty(onto + "division"))) {

                division = model.getProperty(onto + "division");

            } else if (r.hasProperty(model.getProperty("http://dbpedia.org/property/divisio"))) {

                division = model.getProperty("http://dbpedia.org/property/divisio");
            }

            if (r.hasProperty(model.getProperty(onto + "family"))) {

                family = model.getProperty(onto + "family");

            } else if (r.hasProperty(model.getProperty("http://dbpedia.org/property/familia"))) {

                family = model.getProperty("http://dbpedia.org/property/familia");
            }
            
            System.out.println("Class is = " + r.getProperty(classproperty).getObject());
            System.out.println("Kingdom is = " + r.getProperty(kingdom).getObject());
            System.out.println("Family is = " + r.getProperty(family).getObject());
            System.out.println("Division is = " + r.getProperty(division).getObject());
            System.out.println("Order is = " + r.getProperty(order).getObject());
            System.out.println("Image URL is = " + r.getProperty(picture).getObject());

            NodeIterator ni = model.listObjectsOfProperty(r, cmnt);
            while (ni.hasNext()) {

                String s = ni.next().toString();

                if (s.endsWith("@en")) {

                    int ends = s.indexOf("@");
                    searchcomments = s.substring(0, ends);
                    System.out.println("Comments = " + searchcomments);

                }


            }


            int en = n.lastIndexOf("/");
            searchstring = n.substring(en + 1, n.length());
            
            
             if (r.hasProperty(model.getProperty(onto + "division"))) {

            searchdivisio = r.getProperty(division).getObject().toString();
            int end3 = searchdivisio.lastIndexOf("/");
            searchdivisio = searchdivisio.substring(end3 + 1, searchdivisio.length());
            
             } else if (r.hasProperty(model.getProperty("http://dbpedia.org/property/divisio"))) {
             
            searchdivisio = r.getProperty(division).getObject().toString();
            int end3 = searchdivisio.indexOf("@en");
            searchdivisio = searchdivisio.substring(0, end3);
             
             }
             
             
              if (r.hasProperty(model.getProperty(onto + "family"))) {

            searchfamilia = r.getProperty(family).getObject().toString();
            int end6 = searchfamilia.lastIndexOf("/");
            searchfamilia = searchfamilia.substring(end6 + 1, searchfamilia.length());
            
             } else if (r.hasProperty(model.getProperty("http://dbpedia.org/property/familia"))) {
             
            searchfamilia = r.getProperty(family).getObject().toString();
            int end6 = searchfamilia.indexOf("@en");
            searchfamilia = searchfamilia.substring(0, end6);
             
             }
             
             

            searchkingdom = r.getProperty(kingdom).getObject().toString();
            int end5 = searchkingdom.lastIndexOf("/");
            searchkingdom = searchkingdom.substring(end5 + 1, searchkingdom.length());

//            searchfamilia = r.getProperty(family).getObject().toString();
//            int end6 = searchfamilia.lastIndexOf("/");
//            searchfamilia = searchfamilia.substring(end6 + 1, searchfamilia.length());

            searchorder = r.getProperty(order).getObject().toString();
            int end2 = searchorder.lastIndexOf("/");
            searchorder = searchorder.substring(end2 + 1, searchorder.length());

            searchclass = r.getProperty(classproperty).getObject().toString();
            int end1 = searchclass.lastIndexOf("/");
            searchclass = searchclass.substring(end1 + 1, searchclass.length());
            
            searchpicture =  r.getProperty(picture).getObject().toString();

            
        } else {
            
            family = model.getProperty(onto + "family");
            order = model.getProperty(onto + "order");
//            conservationStatus = model.getProperty(onto + "conservationStatus");
            phylum = model.getProperty(onto + "phylum");
            picture = model.getProperty("http://xmlns.com/foaf/0.1/depiction");
  
         if (r.hasProperty(model.getProperty(onto + "class"))) {

                classproperty = model.getProperty(onto + "class");

            } else if (r.hasProperty(model.getProperty("http://dbpedia.org/property/class"))) {

                classproperty = model.getProperty("http://dbpedia.org/property/class");
            }

           if (r.hasProperty(model.getProperty(onto + "family"))) {

                family = model.getProperty(onto + "family");

            } else if (r.hasProperty(model.getProperty("http://dbpedia.org/property/familia"))) {

                family = model.getProperty("http://dbpedia.org/property/familia");
            }

            

            System.out.println("Class is = " + r.getProperty(classproperty).getObject());
            System.out.println("Kingdom is = " + r.getProperty(kingdom).getObject());
            System.out.println("Family is = " + r.getProperty(family).getObject());
            System.out.println("Phylum is = " + r.getProperty(phylum).getObject());
            System.out.println("Order is = " + r.getProperty(order).getObject());
            System.out.println("Image URL is = " + r.getProperty(picture).getObject());
//            System.out.println("Conservation Status is = " + r.getProperty(conservationStatus).getObject());
            
            NodeIterator ni = model.listObjectsOfProperty(r, cmnt);
            while (ni.hasNext()) {

                String s = ni.next().toString();

                if (s.endsWith("@en")) {

                    int ends = s.indexOf("@");
                   searchcomments = s.substring(0, ends);
                    System.out.println("Comments = " + searchcomments);

                }


            }

            int en = n.lastIndexOf("/");
            searchstring = n.substring(en + 1, n.length());
            
            
            if (r.hasProperty(model.getProperty(onto + "family"))) {

            searchfamilia = r.getProperty(family).getObject().toString();
            int end6 = searchfamilia.lastIndexOf("/");
            searchfamilia = searchfamilia.substring(end6 + 1, searchfamilia.length());
            
             } else if (r.hasProperty(model.getProperty("http://dbpedia.org/property/familia"))) {
             
            searchfamilia = r.getProperty(family).getObject().toString();
            int end6 = searchfamilia.indexOf("@en");
            searchfamilia = searchfamilia.substring(0, end6);
             
             }

            
//            searchconstatus = r.getProperty(conservationStatus).getObject().toString();
//            int end8 = searchconstatus.indexOf("@en");
//            searchconstatus = searchconstatus.substring(0, end8);

            searchkingdom = r.getProperty(kingdom).getObject().toString();
            int end5 = searchkingdom.lastIndexOf("/");
            searchkingdom = searchkingdom.substring(end5 + 1, searchkingdom.length());

//            searchfamilia = r.getProperty(family).getObject().toString();
//            int end6 = searchfamilia.lastIndexOf("/");
//            searchfamilia = searchfamilia.substring(end6 + 1, searchfamilia.length());
            
            searchorder = r.getProperty(order).getObject().toString();
            int end2 = searchorder.lastIndexOf("/");
            searchorder = searchorder.substring(end2 + 1, searchorder.length());

            searchclass = r.getProperty(classproperty).getObject().toString();
            int end1 = searchclass.lastIndexOf("/");
            searchclass = searchclass.substring(end1 + 1, searchclass.length());
            
            searchphylum = r.getProperty(phylum).getObject().toString();
            int end7 = searchphylum.lastIndexOf("/");
            searchphylum = searchphylum.substring(end7 + 1, searchphylum.length());
            
            searchpicture =  r.getProperty(picture).getObject().toString();
            
       }

    }

    public String getclass() {

        return searchclass;

    }

    public String getfamilia() {

        return searchfamilia;
    }

    public String getkingdom() {


        return searchkingdom;

    }

    public String getdivisio() {

        return searchdivisio;

    }

    public String getsearchstring() {

        return searchstring;
    }

    public String getorder() {

        return searchorder;

    }

    public String getpicture() {

        return searchpicture;

    }

    public String getcomments() {

        return searchcomments;

    }

    public String getphylum() {

        return searchphylum;

    }

    public String getconservationstatus() {

        return searchconstatus;

    }
    
    public String getorderURL(){
    
    return getWikipediaURL(r.getProperty(order).getObject().toString());
    
    }
    
    public String getclassURL(){
    
//    return getWikipediaURL(r.getProperty(classproperty).getObject().toString());
  return " ";  
    }
    
    public String getfamiliaURL(){
    
    return getWikipediaURL(r.getProperty(family).getObject().toString());
    
    }
    
    public String getkingdomURL(){
    
//    return getWikipediaURL(r.getProperty(kingdom).getObject().toString());
  return " " ;  
    }

    String getWikipediaURL(String s) {

        Model model_w = ModelFactory.createDefaultModel();

        model_w.read(s);
        Resource title = model_w.getResource(s);
        Property p = model_w.getProperty("http://xmlns.com/foaf/0.1/isPrimaryTopicOf");
        System.out.println();
        String url1 = title.getProperty(p).getObject().toString();

        return url1;
    }
}

