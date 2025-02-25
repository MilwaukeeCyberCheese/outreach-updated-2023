package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.other.Stopwatch;
import frc.robot.subsystems.ShooterSubsystem;

public class EjectCommand extends Command {
    private final ShooterSubsystem m_shooterSubsystem;
    private final Stopwatch timer;
    private double topSpeed = 0.0;
    private double bottomSpeed = 0.0;

    //constructor
    public EjectCommand(ShooterSubsystem m_shooterSubsystem) {
        this.m_shooterSubsystem = m_shooterSubsystem;
        timer = new Stopwatch();
        addRequirements(m_shooterSubsystem);
    }

    @Override
    public void execute() {

        if (!timer.isRunning()) {
            timer.start();
        }

       
        if (topSpeed == 0 && bottomSpeed == 0) {

            topSpeed = Constants.subsystems.shooter.TOP_WRONG_BALL_SPEED;
            bottomSpeed = Constants.subsystems.shooter.BOTTOM_WRONG_BALL_SPEED;

        }

        m_shooterSubsystem.drive(topSpeed, bottomSpeed);

        Constants.controllers.servo.set(Constants.subsystems.servo.OPEN_POS);

    }

    @Override
    public boolean isFinished() {
        return timer.getTime() > Constants.subsystems.shooter.EJECT_RUNTIME;
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
        Constants.controllers.servo.set(Constants.subsystems.servo.CLOSED_POS);
        timer.stop();
        timer.reset();
    }
}