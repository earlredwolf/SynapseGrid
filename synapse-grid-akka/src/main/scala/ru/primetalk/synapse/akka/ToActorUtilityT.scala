///////////////////////////////////////////////////////////////
// © ООО «Праймтолк», 2011-2013                              //
// Все права принадлежат компании ООО «Праймтолк».           //
///////////////////////////////////////////////////////////////
/**
 * ${PROJECT_NAME}
 * © Primetalk Ltd., 2013.
 * All rights reserved.
 * Authors: A.Zhizhelev, A.Nehaev, P. Popov
 * (2-clause BSD license) See LICENSE
 *
 * Created: 01.07.13, zhizhelev
 */
package ru.primetalk.synapse.akka

import akka.actor.{Actor, ActorRef}
import ru.primetalk.synapse.core.{Contact, Signal}

/**
 * Helper method that sends signal to the given actor
 */
trait ToActorUtilityT {

	/** Sends the data directly. */
	def signalToActor(actorRef: ActorRef)(signal: Signal[_]) {
    actorRef ! signal
  }

	/** Sends the data directly. */
	def signalDataToActor(actorRef: ActorRef)(signal: Signal[_]) {
    actorRef ! signal.data
  }

	/** Sends a signal with data. */
	def dataToActorContact[T](actorRef: ActorRef, contact: Contact[T])(data: T) {
    actorRef ! Signal(contact, data)
  }
	implicit class ActorWithContact[T](ac : (ActorRef, Contact[T])) {
		val (actorRef, contact) = ac
		def !(data : T)(implicit sender:ActorRef = Actor.noSender) {
			actorRef ! Signal(contact, data)
		}
	}
}
