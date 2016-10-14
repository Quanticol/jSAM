/*
 * Michele Loreti, Concurrency and Mobility Group
 * Universit� di Firenze, Italy
 * (C) Copyright 2013.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Michele Loreti
 */
package org.cmg.ml.sam.prism.obsolete;

import java.util.LinkedList;

/**
 * @author loreti
 *
 */
public class JoinCommand extends Command {

	private LinkedList<Command> commands;
	
	public JoinCommand( Command ... commands ) {
		this.commands = new LinkedList<Command>();
		for( int i=0 ; i<commands.length ; i++ ) {
			addCommand( commands[i] );
		}
	}	
	
	public JoinCommand(LinkedList<Command> commands) {
		this.commands = commands;
	}

	private void addCommand(Command command) {
		if (command instanceof JoinCommand) {
			commands.addAll(((JoinCommand) command).commands);
		} else {
			commands.add(command);
		}
	}

	/* (non-Javadoc)
	 * @see org.cmg.ml.sam.prism.Command#doApply(org.cmg.ml.sam.prism.PrismState, org.cmg.ml.sam.prism.Update)
	 */
	@Override
	protected void doApply(PrismState currentState, Update update) {
		for (Command c : commands) {
			c.doApply(currentState, update);
		}
	}

	/* (non-Javadoc)
	 * @see org.cmg.ml.sam.prism.Command#computeWeight(org.cmg.ml.sam.prism.PrismState)
	 */
	@Override
	protected double computeWeight(PrismState currentState) {
		double toReturn = 1.0;
		for (Command c : commands) {
			toReturn += c.computeWeight(currentState);
		}
		return toReturn;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Command join(Command c) {
		JoinCommand newCommand = new JoinCommand( (LinkedList<Command>) commands.clone() );
		newCommand.addCommand(c);
		return newCommand;
	}
	

}
