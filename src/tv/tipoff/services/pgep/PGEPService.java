package tv.tipoff.services.pgep;

import java.util.List;

import tv.tipoff.services.pgep.dto.Broadcast;
import tv.tipoff.services.pgep.dto.Channel;
import tv.tipoff.services.pgep.dto.Program;

/**
 * Classe de communication avec l'API Pluzz.
 * 
 * @author Sylvain
 *
 */
public interface PGEPService {
	
	/**
	 * Contenu d'une émission spécifique.
	 * 
	 * @param id
	 *   ID de l'émission.
	 */
	public Program getProgram(int id);
	
	/**
	 * Liste des émissions.
	 */
	public List<Program> getPrograms();
	
	/**
	 * Contenu d'une chaîne spécifique.
	 * 
	 * @param id
	 *   ID de la chaîne.
	 */
	public Channel getChannel(int id);
	
	/**
	 * Liste des chaînes.
	 */
	public List<Channel> getChannels();
	
	/**
	 * Liste des difusions des 7 jours à venir, triées par ordre ascendant
	 * d'heure de diffusion. La requête retourne les diffusions déjà entamées
	 * mais non terminées lors de l'appel.
	 */
	public List<Broadcast> getBroadcasts();
	
	/**
	 * Contenu d'une diffusion spécifique.
	 * 
	 * @param id
	 *   ID de la diffusion.
	 */
	public Broadcast getBroadcast(int id);
}
