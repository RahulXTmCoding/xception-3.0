package com.web.application.xception.model;
import java.util.*;
import com.web.application.xception.pojo.request.*;
public class DataModel implements java.io.Serializable
{
private Xception xception;
private List<Team> teams;
private List<Event> events;
private List<Register> registeredStudents;
private List<Sponsor> sponsors;
private List<XceptionSocialMedia> xceptionSocialMedia;
private List<Faq> faqs;
private Map<Integer,List<Sponsor>> sponsorResponse;
private Map<Event.EVENT_TYPE,List<Event>> eventResponse;
private List<String> galleryImages;
public final static String id=java.util.UUID.randomUUID().toString();
public DataModel()
{
this.galleryImages=new LinkedList<>();
this.sponsorResponse=new HashMap<>();
this.xception=null;
this.teams=new LinkedList<>();
this.events=new LinkedList<>();
this.registeredStudents=new LinkedList<>();
this.sponsors=new LinkedList<>();
this.xceptionSocialMedia=new LinkedList<>();
this.faqs=new LinkedList<>();
this.eventResponse=new HashMap<>();
}
public void addGalleryImage(String galleryImage)
{
this.galleryImages.add(galleryImage);
}
public List<String> getGalleryImages()
{
return this.galleryImages;
}
public void setXceptionObject(Xception xception)
{
this.xception=xception;
}
public Xception getXceptionObject()
{
return this.xception;
}
public void addTeam(Team team)
{
this.teams.add(team);
}
public void setTeams(List<Team> teams)
{
this.teams=teams;
}
public  List<Team> getTeams()
{
return this.teams;
}
public Team getTeam(String name)
{
for(Team t:this.teams)
{
if(t.getName().equalsIgnoreCase(name)) return t;
}
return null;
}
public List<Team> getTeamsOrderedByTeamName()
{
List<Team> list=this.teams;
Collections.sort(list,(left,right)->left.getName().toUpperCase().compareTo(right.getName().toUpperCase()));
return list;
}
public List<String> getTeamHeads()
{
List<String> teamHeadNames=new LinkedList<>();
this.teams.forEach(t->{
teamHeadNames.add(t.getHeadName());
});
return teamHeadNames;
}
public List<String> getTeamHeadsOrderedByTeamHeadName()
{
List<String> list=this.getTeamHeads();
Collections.sort(list);
return list;
}
public Team removeFromTeams(String name)
{
for(Team t:this.teams)
{
if(t.getName().equalsIgnoreCase(name)) 
{
this.teams.remove(t);
return t;
}
}
return null;
}
public void removeAllTeams()
{
this.teams.clear();
}
// teams done

//events starts
public void addEvent(Event event)
{
this.events.add(event);
Event.EVENT_TYPE eventType=event.getType();
List<Event> list=this.eventResponse.get(eventType);
if(list==null)
{
list=new LinkedList<>();
this.eventResponse.put(eventType,list);
}
list.add(event);
}
public void setEvents(List<Event> events)
{
this.events=events;
}
public Map<Event.EVENT_TYPE,List<Event>> getEventResponse()
{
return this.eventResponse;
}
public  List<Event> getEvents()
{
return this.events;
}
public Event getEvent(int id)
{
for(Event e:this.events)
{
if(e.getCode()==id) return e;
}
return null;
}
public Event getEvent(String name)
{
for(Event e:this.events)
{
if(e.getName().equalsIgnoreCase(name)) return e;
}
return null;
}
public List<Event> getEventsOrderedByEventId()
{
List<Event> list=this.events;
Collections.sort(list,(left,right)->left.getCode()-right.getCode());
return list;
}
public List<Event> getEventsOrderedByEventName()
{
List<Event> list=this.events;
Collections.sort(list,(left,right)->left.getName().toUpperCase().compareTo(right.getName().toUpperCase()));
return list;
}
public List<String> getEventHeads()
{
List<String> eventHeadNames=new LinkedList<>();
this.events.forEach(t->{
eventHeadNames.add(t.getHeadName());
});
return eventHeadNames;
}
public List<String> getEventHeadsOrderedByEventHeadName()
{
List<String> list=this.getEventHeads();
Collections.sort(list);
return list;
}
public List<Event> getEventsByEventType(Event.EVENT_TYPE eventType)
{
List<Event> list=new LinkedList<>();
for(Event e:this.events)
{
if(e.getType()==eventType)
{
list.add(e);
}
}
return list;
}
public List<Event> getEventsByEventTypeOrderedByEventName(Event.EVENT_TYPE eventType)
{
List<Event> list=this.getEventsByEventType(eventType);
Collections.sort(list,(left,right)->left.getName().toUpperCase().compareTo(right.getName().toUpperCase()));
return list;
}
public Event removeFromEvents(String name)
{
for(Event e:this.events)
{
if(e.getName().equalsIgnoreCase(name)) 
{
this.events.remove(e);
return e;
}
}
return null;
}
public void removeAllEvents()
{
this.events.clear();
}
//events ends
//Registered students
public void addRegisteredStudent(Register register)
{
this.registeredStudents.add(register);
}
public void setRegisteredStudents(List<Register> register)
{
this.registeredStudents=registeredStudents;
}
public  List<Register> getRegisteredStudents()
{
return this.registeredStudents;
}
public Register getRegisteredStudent(int id)
{
for(Register r:this.registeredStudents)
{
if(r.getCode()==id) return r;
}
return null;
}
public List<Register> getRegisteredStudentsOrderedByName()
{
List<Register> list=this.registeredStudents;
Collections.sort(list,(left,right)->left.getName().toUpperCase().compareTo(right.getName().toUpperCase()));
return list;
}
public Register removeFromRegisteredStudents(int id)
{
for(Register r:this.registeredStudents)
{
if(r.getCode()==id) 
{
this.registeredStudents.remove(r);
return r;
}
}
return null;
}
public void removeAllRegisteredStudents()
{
this.registeredStudents.clear();
}
//Registered students ends

//Sponsors starts
public void addSponsor(Sponsor sponsor)
{
this.sponsors.add(sponsor);
int year=sponsor.getYear();
List<Sponsor> list=this.sponsorResponse.get(year); 
if(list==null)
{
list=new LinkedList<>();
this.sponsorResponse.put(year,list);
}
list.add(sponsor);
}
public void setSponsors(List<Sponsor> sponsors)
{
this.sponsors=sponsors;
}
public Map<Integer,List<Sponsor>> getSponsorResponse()
{
return this.sponsorResponse;
}
public List<Sponsor> getSponsors()
{
return this.sponsors;
}
public Sponsor getSponsorById(int id)
{
for(Sponsor s:this.sponsors)
{
if(s.getCode()==id) return s;
}
return null;
}
public Sponsor getSponsorByYear(int year)
{
for(Sponsor s:this.sponsors)
{
if(s.getYear()==year) return s;
}
return null;
}
public List<Sponsor> getSponsorsOrderedById()
{
List<Sponsor> list=this.sponsors;
Collections.sort(list,(left,right)->left.getCode()-right.getCode());
return list;
}
public List<Sponsor> getSponsorsOrderedByName()
{
List<Sponsor> list=this.sponsors;
Collections.sort(list,(left,right)->left.getName().toUpperCase().compareTo(right.getName().toUpperCase()));
return list;
}
public List<Sponsor> getSponsorsOrderedByYear()
{
List<Sponsor> list=this.sponsors;
Collections.sort(list,(left,right)->left.getYear()-right.getYear());
return list;
}
public Sponsor removeFromSponsors(int id)
{
for(Sponsor r:this.sponsors)
{
if(r.getCode()==id) 
{
this.sponsors.remove(r);
return r;
}
}
return null;
}
public void removeAllSponsors()
{
this.sponsors.clear();
}
//sponsor ends
//XceptionSocialMedia starts
public void addXceptionSocialMedia(XceptionSocialMedia xceptionSocialMedia)
{
this.xceptionSocialMedia.add(xceptionSocialMedia);
}
public void setXceptionSocialMedia(List<XceptionSocialMedia> xceptionSocialMedia)
{
this.xceptionSocialMedia=xceptionSocialMedia;
}
public List<XceptionSocialMedia> getXceptionSocialMedia()
{
return this.xceptionSocialMedia;
}
public XceptionSocialMedia getXceptionSocialMedium(String name)
{
for(XceptionSocialMedia s:this.xceptionSocialMedia)
{
if(s.getName().equalsIgnoreCase(name)) return s;
}
return null;
}
public XceptionSocialMedia removeFromXceptionSocialMedia(String name)
{
for(XceptionSocialMedia r:this.xceptionSocialMedia)
{
if(r.getName().equalsIgnoreCase(name)) 
{
this.xceptionSocialMedia.remove(r);
return r;
}
}
return null;
}
public void removeAllXceptionSocialMedia()
{
this.xceptionSocialMedia.clear();
}

//XceptionSocialMedia ends

//faq starts
public void addFaq(Faq faq)
{
this.faqs.add(faq);
}
public void setFaqs(List<Faq> faqs)
{
this.faqs=faqs;
}
public List<Faq> getFaqs()
{
return this.faqs;
}
public List<String> getQuestions()
{
List<String> list=new LinkedList<>();
this.faqs.forEach(f->{
list.add(f.getQuestion());
});
return list;
}
public String getAnswer(String question)
{
for(Faq f:this.faqs)
{
if(f.getQuestion().equalsIgnoreCase(question)) return f.getAnswer();
}
return null;
}
public Faq removeFromFaqs(String question)
{
for(Faq f:this.faqs)
{
if(f.getQuestion().equalsIgnoreCase(question)) 
{
this.faqs.remove(f);
return f;
}
}
return null;
}
public void removeAllFaqs()
{
this.faqs.clear();
}
//faq ends
}//class ends