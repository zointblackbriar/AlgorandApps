'reach 0.1'; 
'use strict'; 

export const main = Reach.App(() => {

  const A = Participant('Role1', {
    request: UInt,
    info: Bytes(128),
  });

  const B = Participant('Role2', {
      want: Fun([UInt], Null),
      got: Fun([Bytes(128)], Null),
  });

  init(); 

  A.only(() => {
      const request = declassify(interact.request);
  });
  A.publish(request);
  commit();

  B.only(() => {
      //performing a delivery
      interact.want(request);
  });

  //Not enough money in the account of ALgo
  B.pay(request);
  commit();

  A.only(() => {
      const info = declassify(interact.info);  
      
  });
  A.publish(info); // Publishing it
  transfer(request).to(A); //requested amount to A 
  commit(); //commits the transaction on the consensus network.
});
