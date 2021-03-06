///////////////////////////////////////////////////////////////
// © ООО «Праймтолк», 2011-2013                              //
// Все права принадлежат компании ООО «Праймтолк».           //
///////////////////////////////////////////////////////////////
/**
 * SynapseGrid
 * © Primetalk Ltd., 2013.
 * All rights reserved.
 * Authors: A.Zhizhelev, A.Nehaev
 *
 * Created: 06.12.13, zhizhelev
 */
package ru.primetalk.synapse

import _root_.rx.lang.scala.Observable
import _root_.rx.lang.scala.subjects.PublishSubject
import core._

package object rx {

  implicit class RichContact[T](c:Contact[T])(implicit sb:BasicSystemBuilder){
    import implicits._
    def toObservable:Observable[T] = {
      val rxOutput = PublishSubject[T]()
      c.foreach(t => rxOutput.onNext(t))
      rxOutput
    }
  }
}
