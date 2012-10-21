
package tv.tipoff.application;

import tv.tipoff.application.model.Program;
import tv.tipoff.application.model.Tuple;
import tv.tipoff.application.model.User;

import java.util.List;

public class algorithm {
	
	public void userProgAffinity (User user ,Program comparedProgram ){
		List<Program> allSeenProgram = user.hasSeen();
		int totalAffinity=0;
		int genreAffinity=0;
		int finalAffinity=0;
		boolean check=false;  
		for(Program program : allSeenProgram){
			for (Tuple<Program, Integer> pr : program.getSimilarTo()){
				if(pr.x.getId() == comparedProgram.getId()){
					totalAffinity=totalAffinity +pr.y;
				}
			}
			if(program.getGenre()==comparedProgram.getGenre()){
				genreAffinity++;
			}
		}
		if(allSeenProgram.size()>0){
			finalAffinity=(genreAffinity+totalAffinity)/(2*allSeenProgram.size());
		}else{
			finalAffinity=genreAffinity/allSeenProgram.size();
		}
		for(Tuple<Program,Integer> tp : user.getAffinity()){
			if(tp.x.getId() == comparedProgram.getId()){
				tp.y=finalAffinity;
				check=true;
			}
		}
		if(!check){
			Tuple<String,Integer> tp = new Tuple<String,Integer>(comparedProgram.getId(),finalAffinity);
			user.addAffinity(tp);
		}

	}
	public void progProgAffinity(Program program){
		List<User> allWatchers = program.getHasBeenSeenBy();
		boolean check=false;
		for(User user: allWatchers){
			List<Program> connectedPrograms = user.hasSeen();
			for(Program connectedProgram : connectedPrograms){
				List<User> connectedWatchers=connectedProgram.getHasBeenSeenBy();
				int watchedBoth=0;
				for(User watcher : allWatchers){
					for(User cwatcher : connectedWatchers){
						if(watcher.getPseudo()==cwatcher.getPseudo()){
							watchedBoth++;
						}
					}
				}
				for(Tuple<Program, Integer> pr : program.getSimilarTo()){
					if(pr.x.getId() == connectedProgram.getId()){
						pr.y=100*watchedBoth/allWatchers.size();
						check=true;
					}
				}
				if(!check){
					Tuple<String,Integer> tp = new Tuple<String,Integer>(connectedProgram.getId(),100*watchedBoth/allWatchers.size());
					program.addSimilarProgram(tp);
					
				}
				check=false;
				for(Tuple<Program, Integer> pr : connectedProgram.getSimilarTo()){
					if(pr.x.getId() == program.getId()){
						pr.y=100*watchedBoth/connectedWatchers.size();
						check=true;
					}
				}
				if(!check){
					Tuple<String,Integer> tp = new Tuple<String,Integer>(program.getId(),100*watchedBoth/connectedWatchers.size());
					connectedProgram.addSimilarProgram(tp);
					
				}
			}
		}
	}
	
}
