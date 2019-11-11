# task-cabinet-server


## Installation
ref. https://github.com/MokkeMeguru/tcs-notification

Copy `profiles.clj` from the above repository.

example:
```
{:dev {:env {
             :database-url "jdbc:postgresql://localhost/dev"
             :clj-env "dev"
             :vapid-pub "<vapid-pub-key>"
             :vapid-private "<vapid-client-key>"}}
 :test {:env {
              :database-url "jdbc:postgresql://localhost/dev"
              :clj-env "test"
              :vapid-pub "<vapid-pub-key>"
              :vapid-private "<vapid-client-key>"}}}
```
## Usage

```
docker-compose run --service-port repl
lein repl
(start)
```
accessing http://localhost:3000/swagger-ui, You can see swagger view. Call any endpoint according to its description.

## Options

FIXME: listing of options this app accepts.

## Examples

...

### Bugs

...

### Any Other Sections
### That You Think
### Might be Useful

## License

Copyright © 2019 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
