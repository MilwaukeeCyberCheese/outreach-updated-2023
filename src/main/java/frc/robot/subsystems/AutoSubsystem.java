package frc.robot.subsystems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.MecanumDriveKinematics;
import edu.wpi.first.math.kinematics.MecanumDriveWheelSpeeds;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class AutoSubsystem extends SubsystemBase {

    // 36 and 3/4 is an important number

    private ChassisSpeeds m_chassisSpeeds = new ChassisSpeeds(0.0, 0.0, 0.0);

    // the following lists store data relating to the preprogrammed auto paths
    // private List<ChassisSpeeds> speeds = new LinkedList<ChassisSpeeds>();
    // private List<Double> intaking = new LinkedList<Double>();
    // private List<Double> topSpeeds = new LinkedList<Double>();
    // private List<Double> bottomSpeeds = new LinkedList<Double>();
    // private List<Double> servos = new LinkedList<Double>();
    private List<ChassisSpeeds> speeds = new LinkedList(Arrays.asList(new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,0.05110739104280681),new ChassisSpeeds(0.0,-0.0,0.16505508184713247),new ChassisSpeeds(0.0,-0.0,0.2303884905289814),new ChassisSpeeds(0.0,-0.0,0.3536216031463773),new ChassisSpeeds(0.0,-0.05794692072430109,0.48018243918811065),new ChassisSpeeds(-0.13164817358974684,-0.2271961633136409,0.6925529175630589),new ChassisSpeeds(-0.28204910551748413,-0.3362493140393711,0.820683687639661),new ChassisSpeeds(-0.4200673520228638,-0.4368824178579151,0.9121424088504813),new ChassisSpeeds(-0.4993507864298004,-0.5290030641730549,0.9920480257534202),new ChassisSpeeds(-0.4993507864298004,-0.5397822634680548,0.9920480257534202),new ChassisSpeeds(-0.4993507864298004,-0.5506701787879006,0.9920480257534202),new ChassisSpeeds(-0.4993507864298004,-0.5506701787879006,0.9920480257534202),new ChassisSpeeds(-0.4993507864298004,-0.5727721575021301,0.9920480257534202),new ChassisSpeeds(-0.4993507864298004,-0.5839862208965138,0.9920480257534202),new ChassisSpeeds(-0.41063853105735204,-0.6067404957598193,0.9920480257534202),new ChassisSpeeds(-0.41063853105735204,-0.6067404957598193,0.9920480257534202),new ChassisSpeeds(-0.41063853105735204,-0.6067404957598193,0.9920480257534202),new ChassisSpeeds(-0.41063853105735204,-0.6182807072287407,0.9920480257534202),new ChassisSpeeds(-0.41063853105735204,-0.6182807072287407,0.9920480257534202),new ChassisSpeeds(-0.5097428240660226,-0.6182807072287407,0.9920480257534202),new ChassisSpeeds(-0.5308479715620376,-0.5077707341186781,0.9920480257534202),new ChassisSpeeds(-0.5523812153561461,-0.49731768372117413,0.9920480257534202),new ChassisSpeeds(-0.5854837616062346,-0.486973349348516,0.706252940209222),new ChassisSpeeds(-0.5967319918386442,-0.45659264237961744,0.4040070928979367),new ChassisSpeeds(-0.6080872461455773,-0.44668317210634323,0.07130184166227337),new ChassisSpeeds(-0.6195495245270335,-0.4176070574355964,-0.0),new ChassisSpeeds(-0.6311188269830134,-0.4176070574355964,-0.0),new ChassisSpeeds(-0.6427951535135166,-0.40813245126170616,-0.0),new ChassisSpeeds(-0.6545785041185431,-0.3987665611126617,-0.0),new ChassisSpeeds(-0.6664688787980931,-0.3987665611126617,-0.0),new ChassisSpeeds(-0.6664688787980931,-0.37132118681460446,-0.14831373215647256),new ChassisSpeeds(-0.6664688787980931,-0.37132118681460446,-0.14831373215647256),new ChassisSpeeds(-0.7400586324403845,-0.24877092300539327,-0.9273582611770476),new ChassisSpeeds(-0.7912589496923803,-0.1999519156366476,-0.9920480257534202),new ChassisSpeeds(-0.7912589496923803,-0.1806602481397853,-0.9920480257534202),new ChassisSpeeds(-0.7912589496923803,-0.1806602481397853,-0.9920480257534202),new ChassisSpeeds(-0.7912589496923803,-0.17444712435718976,-0.9920480257534202),new ChassisSpeeds(-0.7912589496923803,-0.17444712435718976,-0.9920480257534202),new ChassisSpeeds(-0.7912589496923803,-0.17444712435718976,-0.9920480257534202),new ChassisSpeeds(-0.7912589496923803,-0.17444712435718976,-0.9920480257534202),new ChassisSpeeds(-0.7912589496923803,-0.17444712435718976,-0.9920480257534202),new ChassisSpeeds(-0.7912589496923803,-0.3110869787319528,-0.4655472780978423),new ChassisSpeeds(-0.6195495245270335,-0.3987665611126617,-0.0866157930641469),new ChassisSpeeds(-0.5202418857767684,-0.5183325809029011,-0.0),new ChassisSpeeds(-0.41063853105735204,-0.5953090003157435,-0.0),new ChassisSpeeds(-0.3305952257212994,-0.6776125049460384,-0.0),new ChassisSpeeds(-0.27433266974434684,-0.7270349267422246,-0.0),new ChassisSpeeds(-0.20970083113966426,-0.7652431924377803,-0.0),new ChassisSpeeds(-0.17142902209009547,-0.7912589496923803,-0.0),new ChassisSpeeds(-0.15373794257137707,-0.7912589496923803,-0.0),new ChassisSpeeds(-0.14805496421418438,-0.7912589496923803,-0.0),new ChassisSpeeds(-0.14805496421418438,-0.7912589496923803,-0.0),new ChassisSpeeds(-0.14805496421418438,-0.7912589496923803,-0.0),new ChassisSpeeds(-0.14805496421418438,-0.7912589496923803,-0.0),new ChassisSpeeds(-0.14805496421418438,-0.7912589496923803,-0.0),new ChassisSpeeds(-0.14805496421418438,-0.7912589496923803,-0.0),new ChassisSpeeds(-0.24453716739703155,-0.7912589496923803,-0.0),new ChassisSpeeds(-0.2898725653651449,-0.7912589496923803,-0.0),new ChassisSpeeds(-0.3058405572840366,-0.7912589496923803,-0.0),new ChassisSpeeds(-0.3058405572840366,-0.7912589496923803,-0.0),new ChassisSpeeds(-0.3139850893552674,-0.7912589496923803,-0.0),new ChassisSpeeds(-0.3139850893552674,-0.7912589496923803,-0.0),new ChassisSpeeds(-0.3139850893552674,-0.7912589496923803,-0.0),new ChassisSpeeds(-0.3139850893552674,-0.7912589496923803,-0.0),new ChassisSpeeds(-0.3139850893552674,-0.7912589496923803,-0.0),new ChassisSpeeds(-0.3139850893552674,-0.7912589496923803,-0.0),new ChassisSpeeds(-0.3139850893552674,-0.7912589496923803,-0.0),new ChassisSpeeds(-0.3139850893552674,-0.7912589496923803,-0.0),new ChassisSpeeds(-0.3139850893552674,-0.7912589496923803,-0.0),new ChassisSpeeds(-0.3139850893552674,-0.7912589496923803,-0.0),new ChassisSpeeds(-0.24453716739703155,-0.7912589496923803,-0.0),new ChassisSpeeds(-0.20305463611176094,-0.7912589496923803,-0.0),new ChassisSpeeds(-0.17142902209009547,-0.7912589496923803,-0.0),new ChassisSpeeds(-0.10172424235300354,-0.7912589496923803,-0.0),new ChassisSpeeds(-0.10172424235300354,-0.7912589496923803,-0.0),new ChassisSpeeds(-0.06406247052821822,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(-0.029804064273277104,-0.7912589496923803,-0.0),new ChassisSpeeds(-0.11620459963601987,-0.689805012564036,-0.0),new ChassisSpeeds(-0.37399348794053916,-0.5953090003157435,-0.0),new ChassisSpeeds(-0.5308479715620376,-0.4368824178579151,-0.0),new ChassisSpeeds(-0.6664688787980931,-0.362390160764944,-0.0),new ChassisSpeeds(-0.6905707003807634,-0.3362493140393711,-0.0),new ChassisSpeeds(-0.6905707003807634,-0.3362493140393711,-0.0),new ChassisSpeeds(-0.6905707003807634,-0.31936570780957957,-0.0),new ChassisSpeeds(-0.6905707003807634,-0.31936570780957957,-0.0),new ChassisSpeeds(-0.7151006182615273,-0.2948556686512371,-0.0),new ChassisSpeeds(-0.7526981756415985,-0.2790592226699053,-0.0),new ChassisSpeeds(-0.7654447429173357,-0.26369764078795727,-0.0),new ChassisSpeeds(-0.7782983342675962,-0.2561799238842523,-0.0),new ChassisSpeeds(-0.7782983342675962,-0.24877092300539327,-0.0),new ChassisSpeeds(-0.7782983342675962,-0.24877092300539327,-0.0),new ChassisSpeeds(-0.7782983342675962,-0.24147063815138017,-0.0),new ChassisSpeeds(-0.7782983342675962,-0.24147063815138017,-0.0),new ChassisSpeeds(-0.7782983342675962,-0.24147063815138017,-0.0),new ChassisSpeeds(-0.7912589496923803,-0.23427906932221312,-0.0),new ChassisSpeeds(-0.7912589496923803,-0.2271961633136409,-0.0),new ChassisSpeeds(-0.7912589496923803,-0.206599903518627,-0.0),new ChassisSpeeds(-0.5854837616062346,-0.17444712435718976,-0.0),new ChassisSpeeds(-0.3829942126079573,-0.11327800160444973,-0.0),new ChassisSpeeds(-0.10644400403948556,-0.06908488265440525,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(-0.024966576104819314,-0.0,-0.0),new ChassisSpeeds(-0.22331429341904097,-0.0,-0.0),new ChassisSpeeds(-0.5523812153561461,-0.020988873482814387,-0.0),new ChassisSpeeds(-0.7151006182615273,-0.0231795024944538,-0.0),new ChassisSpeeds(-0.7912589496923803,-0.02547884753093918,-0.0),new ChassisSpeeds(-0.7912589496923803,-0.02547884753093918,-0.0),new ChassisSpeeds(-0.7912589496923803,-0.02547884753093918,-0.0),new ChassisSpeeds(-0.7912589496923803,-0.02547884753093918,-0.0),new ChassisSpeeds(-0.429603197062899,-0.0,-0.0),new ChassisSpeeds(-0.09260579120360962,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.3029169656791719,-0.0,-0.0),new ChassisSpeeds(0.6776125049460384,-0.0,-0.0),new ChassisSpeeds(0.6776125049460384,-0.0,-0.0),new ChassisSpeeds(0.7912589496923803,-0.0,-0.0),new ChassisSpeeds(0.4368824178579151,-0.0,-0.0),new ChassisSpeeds(0.1806602481397853,-0.0,-0.0),new ChassisSpeeds(0.1806602481397853,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.15068176781089143,-0.0),new ChassisSpeeds(0.0,-0.37132118681460446,-0.0),new ChassisSpeeds(0.0,-0.689805012564036,-0.0),new ChassisSpeeds(0.0,-0.689805012564036,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.46661082867773773,-0.0),new ChassisSpeeds(0.0,-0.1999519156366476,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0652635126528579,-0.0,-0.0),new ChassisSpeeds(0.3448541911915358,-0.0,-0.0),new ChassisSpeeds(0.5727721575021301,-0.0,-0.0),new ChassisSpeeds(0.7781967130526573,-0.0,-0.0),new ChassisSpeeds(0.7912589496923803,-0.0,-0.0),new ChassisSpeeds(0.7912589496923803,-0.0,-0.0),new ChassisSpeeds(0.7912589496923803,-0.0,-0.0),new ChassisSpeeds(0.03302918386095126,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0854575392242013,-0.0),new ChassisSpeeds(0.0,-0.0854575392242013,-0.0),new ChassisSpeeds(0.0,-0.5397822634680548,-0.0),new ChassisSpeeds(0.0,-0.5397822634680548,-0.0),new ChassisSpeeds(0.0,-0.641687278241122,-0.0),new ChassisSpeeds(0.0,-0.3987665611126617,-0.0),new ChassisSpeeds(0.0,-0.3987665611126617,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.05794692072430109,-0.0),new ChassisSpeeds(0.0,-0.2713240737165083,-0.0),new ChassisSpeeds(0.0,-0.5397822634680548,-0.0),new ChassisSpeeds(0.0,-0.6655287133528871,-0.0),new ChassisSpeeds(0.0,-0.7652431924377803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.7912589496923803,-0.0),new ChassisSpeeds(0.0,-0.4767377310007039,-0.0),new ChassisSpeeds(0.0,-0.11327800160444973,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0),new ChassisSpeeds(0.0,-0.0,-0.0)));
private List<Double> intaking = new LinkedList<Double>(Arrays.asList(0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,1.0,1.0,1.0,1.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0));
private List<Double> topSpeeds = new LinkedList<Double>(Arrays.asList(0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.3,0.0,0.0,0.0));
private List<Double> bottomSpeeds = new LinkedList<Double>(Arrays.asList(0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,1.65,0.0,0.0,0.0));
private List<Double> servos = new LinkedList<Double>(Arrays.asList(0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.25,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.25,0.25,0.25));


    private static final MecanumDriveKinematics m_kinematics = new MecanumDriveKinematics(
                        // Front left
                        new Translation2d(Constants.dimensions.TRACKWIDTH / 2.0, Constants.dimensions.WHEELBASE / 2.0),
                        // Front right
                        new Translation2d(Constants.dimensions.TRACKWIDTH / 2.0, -Constants.dimensions.WHEELBASE / 2.0),
                        // Back left
                        new Translation2d(-Constants.dimensions.TRACKWIDTH / 2.0, Constants.dimensions.WHEELBASE / 2.0),
                        // Back right
                        new Translation2d(-Constants.dimensions.TRACKWIDTH / 2.0, -Constants.dimensions.WHEELBASE / 2.0));

    private int stopwatchCounter = -1;

    /**
     * This function is called every few milliseconds when the robot is enabled
     * 
     * For this subsystem, this function drives all auto paths
     */
    @Override
    public void periodic() {
        if (DriverStation.isAutonomousEnabled() && stopwatchCounter < speeds.size() - 1) { 
            stopwatchCounter++;
            
            // shoot
            double topSpeed = this.topSpeeds.get(stopwatchCounter);              
            double bottomSpeed = this.bottomSpeeds.get(stopwatchCounter);  
            
            Constants.controllers.shooterTopSpark.set(topSpeed);
            Constants.controllers.shooterBottomSpark.set(bottomSpeed);

            // intake
            double intake = this.intaking.get(stopwatchCounter);
                
            Constants.controllers.intakeSpark.set(intake);

            // servos
            if (stopwatchCounter < servos.size() - 1) {
                double servo = this.servos.get(stopwatchCounter);

                Constants.controllers.servo.set(servo);
            }
            
            m_chassisSpeeds = this.speeds.get(stopwatchCounter);

            // drive using m_chassisSpeeds
            // get the wheel speeds
            MecanumDriveWheelSpeeds wheelSpeeds = m_kinematics.toWheelSpeeds(m_chassisSpeeds);
        
            // get the individual wheel speeds
            double leftFrontSpeed = wheelSpeeds.frontLeftMetersPerSecond;
            double rightFrontSpeed = wheelSpeeds.frontRightMetersPerSecond;
            double leftRearSpeed = wheelSpeeds.rearLeftMetersPerSecond;
            double rightRearSpeed = wheelSpeeds.rearRightMetersPerSecond;
            
            Constants.controllers.rightRearSpark.set(rightRearSpeed);
            Constants.controllers.leftRearSpark.set(-leftRearSpeed);
            Constants.controllers.rightFrontSpark.set(rightFrontSpeed);
            Constants.controllers.leftFrontSpark.set(-leftFrontSpeed);
        } else if (DriverStation.isAutonomousEnabled() && stopwatchCounter >= speeds.size() - 1) {
            // if we run out of code to run in auto, make sure everything is not moving
            Constants.controllers.shooterTopSpark.set(0.0);
            Constants.controllers.shooterBottomSpark.set(0.0);
            Constants.controllers.intakeSpark.set(0.0);

            Constants.controllers.servo.set(Constants.subsystems.servo.CLOSED_POS);

            Constants.controllers.leftFrontSpark.set(0.0);
            Constants.controllers.leftRearSpark.set(0.0);
            Constants.controllers.rightFrontSpark.set(0.0);
            Constants.controllers.rightRearSpark.set(0.0);
        }
    } 

    /**
     * This function is called when the button on the controller to operate this subsystem is activated
     * 
     * @param speed The speed to move this subsystem at
     */
    public void drive(ChassisSpeeds chassisSpeeds) {
        m_chassisSpeeds = chassisSpeeds;
    }

    /**
     * The following functions all are used to preprogram the auto paths
     */
    public void addSpeed(ChassisSpeeds speed) {
        this.speeds.add(speed);
    }

    public void addIntaking(double intake) {
        this.intaking.add(intake);
    }

    public void addShooting(double topSpeed, double bottomSpeed) {
        this.topSpeeds.add(topSpeed);
        this.bottomSpeeds.add(bottomSpeed);
    }

    public void addServo(double servo) {
        this.servos.add(servo);
    }

    public void clearShit() {
        servos.clear();
        topSpeeds.clear();
        bottomSpeeds.clear();
        speeds.clear();
        intaking.clear();
    }

    public void printSpeeds() {
        String toPrint = "";

        // append the drive speeds
        toPrint += "private List<ChassisSpeeds> speeds = new LinkedList(Arrays.asList(";
        for (int i = 0; i < speeds.size(); i++) {
            ChassisSpeeds speed = speeds.get(i);
            toPrint += "new ChassisSpeeds(";
            toPrint += speed.vxMetersPerSecond + ",";
            toPrint += speed.vyMetersPerSecond + ",";;
            toPrint += speed.omegaRadiansPerSecond + ")";

            if (i != speeds.size() - 1) {
                toPrint += ",";
            }
        }
        toPrint += "));";

        // append the intake speeds
        toPrint += "\n\nprivate List<Double> intaking = new LinkedList<Double>(Arrays.asList(";
        for (int i = 0; i < intaking.size(); i++) {
            double intake = intaking.get(i);
            toPrint += intake;

            if (i != intaking.size() - 1) {
                toPrint += ",";
            }
        }
        toPrint += "));\n";

        // append the shooter speeds
        toPrint += "\n\nprivate List<Double> topSpeeds = new LinkedList<Double>(Arrays.asList(";
        for (int i = 0; i < topSpeeds.size(); i++) {
            double shoot = topSpeeds.get(i);
            toPrint += shoot;

            if (i != topSpeeds.size() - 1) {
                toPrint += ",";
            }
        }
        toPrint += "));\n";
        
        // append the shooter speeds
        toPrint += "\n\nprivate List<Double> bottomSpeeds = new LinkedList<Double>(Arrays.asList(";
        for (int i = 0; i < bottomSpeeds.size(); i++) {
            double shoot = bottomSpeeds.get(i);
            toPrint += shoot;

            if (i != bottomSpeeds.size() - 1) {
                toPrint += ",";
            }
        }
        toPrint += "));\n";

        // append the servo speeds
        toPrint += "\n\nprivate List<Double> servos = new LinkedList<Double>(Arrays.asList(";
        for (int i = 0; i < servos.size(); i++) {
            double servo = servos.get(i);
            toPrint += servo;

            if (i != servos.size() - 1) {
                toPrint += ",";
            }
        }
        toPrint += "));\n";
        
        System.out.println("\n");
        System.out.println("\n");
        System.out.println(toPrint);
        System.out.println("\n");
        System.out.println("\n");

        servos.clear();
        speeds.clear();
        topSpeeds.clear();
        bottomSpeeds.clear();
        intaking.clear();
    }
}
