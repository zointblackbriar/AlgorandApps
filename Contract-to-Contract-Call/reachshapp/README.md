### RUNNING APPLICATIONS

```bash
~/reach/reach compile index.rsh
```

Run in the Algorand Testnet

```bash
REACH_CONNECTOR_MODE=ALGO ~/reach/reach run
```

In order to see Solidity files and rest of the intermediate files, please type the following command

```bash
~/reach/reach compile index.rsh --intermediate-files
```

You need to define a client application, which means that a main.mjs file.

And then it is good to go. (If you like, you can assign ethereum test network with REACH_CONNECTOR_MODE)

```bash
export REACH_CONNECTOR_MODE=ETH
~/reach/reach run
```