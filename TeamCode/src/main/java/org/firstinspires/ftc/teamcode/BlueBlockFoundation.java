/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S ENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

//import org.firstinspires.ftc.Terrycontroller.external.samples.HardwarePushbot;

/**
 * This file illustrates the concept of driving a path based on encoder counts.
 * It uses the common Pushbot hardware class to define the drive on the Terry.
 * The code is structured as a LinearOpMode
 *
 * The code REQUIRES that you DO have encoders on the wheels,
 *   otherwise you would use: PushbotAutoDriveByTime;
 *
 *  This code ALSO requires that the drive Motors have been configured such that a positive
 *  power command moves them forwards, and causes the encoders to count UP.
 *
 *   The desired path in this example is:
 *   - Drive forward for 48 inches
 *   - Spin right for 12 Inches
 *   - Drive Backwards for 24 inches
 *   - Stop and close the claw.
 *
 *  The code is written using a method called: encoderDrive(speed, leftInches, rightInches, timeoutS)
 *  that performs the actual movement.
 *  This methods assumes that each movement is relative to the last stopping place.
 *  There are other ways to perform encoder based moves, but this method is probably the simplest.
 *  This code uses the RUN_TO_POSITION mode to enable the Motor controllers to generate the run profile
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@Autonomous(name="BlueBlockFoundation", group="Linear Opmode")
//@Disabled
public class BlueBlockFoundation extends LinearOpMode {

    /* Declare OpMode members. */
    TechbotHardware2         Terry   = new TechbotHardware2();   // Use a Pushbot's hardware
    private ElapsedTime     runtime = new ElapsedTime();

    static final double     COUNTS_PER_MOTOR_REV    = 537.6 ;    // eg: TETRIX Motor Encoder - 1440
    static final double     WHEEL_DIAMETER_INCHES   = 4.0 ;     // For figuring circumference
    static final double     DRIVE_GEAR_REDUCTION    = 1 ;     // This is < 1.0 if geared UP
    static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
                                                      (WHEEL_DIAMETER_INCHES * 3.1415);
    static final double     DRIVE_SPEED             = 0.6;
    static final double     TURN_SPEED              = 0.5;
    static final double SLIDEL_SPEED = 0.6;
    static final double SLIDER_SPEED = 0.6;
    static final double STOP = 0;

    @Override
    public void runOpMode() {

        /*
         * Initialize the drive system variables.
         * The init() method of the hardware class does all the work here
         */
        Terry.init(hardwareMap);

        telemetry.addData("Status", "Resetting         // Send telemetry message to signify Terry waiting;\nEncoders");    //
        telemetry.update();

        Terry.leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Terry.rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Terry.leftBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Terry.rightBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        Terry.leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Terry.rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Terry.leftBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Terry.rightBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        // Turn On RUN_TO_POSITION
        Terry.leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Terry.rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Terry.leftBackDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Terry.rightBackDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);



        // Send telemetry message to indicate successful Encoder reset
        telemetry.addData("Path0",  "Starting at %7d :%7d :%7d :%7d",
                Terry.leftDrive.getCurrentPosition(),
                Terry.rightDrive.getCurrentPosition(),
                Terry.leftBackDrive.getCurrentPosition(),
                Terry.rightBackDrive.getCurrentPosition());

        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();


        // Step through each leg of the path,
        // Note: Reverse movement is obtained by setting a negative distance (not speed)

        //For this code start with the outside of the left wheel on the crack between the second and third block.
        // Also make sure that the hand is facing forward ready to pick up the block.

        Terry.servoHand.setPosition(1);

        encoderDrive(DRIVE_SPEED/2,  -23,  -23, -23, -23);

        encoderDrive(SLIDEL_SPEED, -62, 62, 62, -62);

        encoderDrive(DRIVE_SPEED/2, -7.3,-7.3,-7.3,-7.3);

        Terry.servoHand.setPosition(0.2);
        // Hand is closed on block

        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1)) {
        }

        Terry.larm.setPower(0);

        Terry.larm.setPower(0.4);

        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 0.5)) {
        }

        Terry.larm.setPower(0);

        encoderDrive(DRIVE_SPEED, 11, 11, 11,11);

        encoderDrive(SLIDER_SPEED,91, -91,-91,91);

        Terry.larm.setPower(0.4);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 0.5)) {
        }

        Terry.larm.setPower(0);

        encoderDrive(DRIVE_SPEED, -10, -10, -10, -10);
        // Terry is in front of foundation with stone hovering over

        Terry.servoHand.setPosition(1);
        // Block is let go and land on the foundation

      encoderDrive(SLIDER_SPEED,10,-10,-10,10);

      encoderDrive(DRIVE_SPEED, -2, -2, -2, -2);

      //  Terry.servoHand.setPosition(0);

        // Start of foundation part

       // encoderDrive(DRIVE_SPEED/2, -7,-7,-7,-7);
        // Robot is in front of foundation
        runtime.reset();
        while (opModeIsActive ()&& (runtime.seconds() < 1)){
        }

        Terry.fervoL.setPosition(0);
        Terry.fervoR.setPosition(0);
        // Hooked on foundation

        runtime.reset();
        while (opModeIsActive ()&& (runtime.seconds() < 0.5)){
        }

        encoderDrive(DRIVE_SPEED,38,38,38,38);

        Terry.fervoL.setPosition(0.5);
        Terry.fervoR.setPosition(0.5);

        runtime.reset();
        while (opModeIsActive ()&& (runtime.seconds() < 0.5)){
        }

        encoderDrive(SLIDEL_SPEED,-35,35,35,-35);

        Terry.servoHand.setPosition(0);

        encoderDrive(DRIVE_SPEED, -22, -22, -22, -22);

        encoderDrive(SLIDEL_SPEED, -15, 15, 15, -15);
        // Parked under bridge
    }

    /*
     *  Method to preform a relative move, based on encoder counts.
     *  Encoders are not reset as the move is based on the current position.
     *  Move will stop if any of three conditions occur:
     *  1) Move gets to the desired position
     *  2) Move runs out of time
     *  3) Driver stops the opmode running.
     */
    public void encoderDrive(double speed,
                             double leftInches, double rightInches, double leftBackInches, double rightBackInches) {
        int newLeftTarget;
        int newRightTarget;
        int newLeftBackTarget;
        int newRightBackTarget;

        // Ensure that the opmode is still active
        if (opModeIsActive()) {

            // Determine new target position, and pass to motor controller
            newLeftTarget = Terry.leftDrive.getCurrentPosition() + (int)(leftInches * COUNTS_PER_INCH);
            newRightTarget = Terry.rightDrive.getCurrentPosition() + (int)(rightInches * COUNTS_PER_INCH);
            newLeftBackTarget = Terry.leftBackDrive.getCurrentPosition() + (int)(leftBackInches * COUNTS_PER_INCH);
            newRightBackTarget = Terry.rightBackDrive.getCurrentPosition() + (int)(rightBackInches * COUNTS_PER_INCH);


            Terry.leftDrive.setTargetPosition(newLeftTarget);
            Terry.rightDrive.setTargetPosition(newRightTarget);
            Terry.leftBackDrive.setTargetPosition(newLeftBackTarget);
           Terry.rightBackDrive.setTargetPosition(newRightBackTarget);


            // reset the timeout time and start motion.
            runtime.reset();
            Terry.leftDrive.setPower(Math.abs(speed));
            Terry.rightDrive.setPower(Math.abs(speed));
            Terry.leftBackDrive.setPower(Math.abs(speed));
            Terry.rightBackDrive.setPower(Math.abs(speed));



            // keep looping while we are still active, and there is time left, and both motors are running.
            // Note: We use (isBusy() && isBusy()) in the loop test, which means that when EITHER motor hits
            // its target position, the motion will stop.  This is "safer" in the event that the Terry will
            // always end the motion as soon as possible.
            // However, if you require that BOTH motors have finished their moves before the Terry continues
            // onto the next step, use (isBusy() || isBusy()) in the loop test.
            //while (Terry.rightDrive.getCurrentPosition() < newRightTarget && opModeIsActive()) {
            while (opModeIsActive() && (Terry.rightDrive.isBusy() || Terry.leftBackDrive.isBusy() || Terry.leftDrive.isBusy() || Terry.leftBackDrive.isBusy()));

                // Display it for the driver.
                telemetry.addData("TargetPos",  "Running to %7d :%7d :%7d :%7d", newLeftTarget,  newRightTarget, newLeftBackTarget, newRightBackTarget);
                telemetry.addData("CurrentPos",  "Running at %7d :%7d :%7d :%7d",
                                            Terry.leftDrive.getCurrentPosition(),
                                            Terry.rightDrive.getCurrentPosition(),
                                            Terry.rightDrive.getCurrentPosition(),
                                            Terry.rightDrive.getCurrentPosition());

                telemetry.update();
            }
            Terry.leftDrive.setPower(0);
            Terry.rightDrive.setPower(0);
            Terry.leftBackDrive.setPower(0);
            Terry.rightBackDrive.setPower(0);

        Terry.leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Terry.rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Terry.leftBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Terry.rightBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        Terry.leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Terry.rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Terry.leftBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Terry.rightBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        // Turn On RUN_TO_POSITION
        Terry.leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Terry.rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Terry.leftBackDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Terry.rightBackDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);


            // Turn off RUN_TO_POSITION
           /* Terry.leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            Terry.rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            Terry.leftBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            Terry.rightBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
*/

//             sleep(250);   // optional pause after each move
        }
    }

