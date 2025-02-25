package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.other.Stopwatch;
import frc.robot.subsystems.ServoSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class LowShooterCommand extends Command {
    private final ShooterSubsystem m_shooterSubsystem;
    private final ServoSubsystem m_servoSubsystem;
    private final Stopwatch timer;
    private double topSpeed = 0.0;
    private double bottomSpeed = 0.0;

    //constructor
    public LowShooterCommand(ShooterSubsystem m_shooterSubsystem, ServoSubsystem m_servoSubsystem) {
        this.m_shooterSubsystem = m_shooterSubsystem;
        this.m_servoSubsystem = m_servoSubsystem;
        timer = new Stopwatch();
        addRequirements(m_shooterSubsystem);
    }

    @Override
    public void execute() {

        if (!timer.isRunning()) {
            timer.start();
        }

        // this will spit the ball out nicely if the ball color does not match alliance
        // color
        if (topSpeed == 0 && bottomSpeed == 0) {
            if (Robot.getColorSensor().getProximity() > 350
                    && (Robot.getColorSensor().getRed() > Robot.getColorSensor().getBlue()
                            && RobotContainer.getAlliance() != DriverStation.Alliance.Red
                            || Robot.getColorSensor().getBlue() > Robot.getColorSensor().getRed()
                                    && RobotContainer.getAlliance() != DriverStation.Alliance.Blue)) {
                topSpeed = Constants.subsystems.shooter.TOP_WRONG_BALL_SPEED;
                bottomSpeed = Constants.subsystems.shooter.BOTTOM_WRONG_BALL_SPEED;
            } else {
                topSpeed = Constants.subsystems.shooter.LOW_TOP_SPEED;
                bottomSpeed = Constants.subsystems.shooter.LOW_BOTTOM_SPEED;
            }
        }

        m_shooterSubsystem.drive(topSpeed, bottomSpeed);

        if (timer.getTime() > 1100) {
            m_servoSubsystem.drive(Constants.subsystems.servo.OPEN_POS);
        } else {
            m_servoSubsystem.drive(Constants.subsystems.servo.CLOSED_POS);
        }
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    /**
     * This function ensures when the action is complete, the robot stops moving
     * 
     * @param interrupted
     */
    @Override
    public void end(boolean interrupted) {
        topSpeed = 0.0;
        bottomSpeed = 0.0;
        m_shooterSubsystem.drive(0.0, 0.0);
        m_servoSubsystem.drive(Constants.subsystems.servo.CLOSED_POS);
        timer.stop();
        timer.reset();
    }
}